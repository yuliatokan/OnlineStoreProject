package edu.store.controller;

import edu.store.dto.UserDTO;
import edu.store.entity.UserAccount;
import edu.store.entity.UserRole;
import edu.store.service.EmailSenderService;
import edu.store.service.ProductTypeService;
import edu.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private EmailSenderService emailSenderService;

    @RequestMapping(value = "/")
    public String index(HttpSession session, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            UserAccount dbUser = userService.findByEmail(email);
            if (dbUser != null) {
                session.setAttribute("exist_user", true);
                session.setAttribute("name", dbUser.getName());
                session.setAttribute("admin", isAdmin(dbUser.getRole().toString()));
            } else {
                session.setAttribute("exist_user", false);
            }
        } else {
            session.setAttribute("exist_user", false);
        }
        return "index";
    }

    private boolean isAdmin(String role) {
        if ("ROLE_ADMIN".equals(role))
            return true;
        return false;
    }

    @RequestMapping("/2doList")
    public String aut() {
        return "2doList";
    }

    @RequestMapping("/sign_in")
    public String sign_in() {
        return "sign_in";
    }

    @RequestMapping("/sign_up")
    public String sign_up() {
        return "sign_up";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String update(HttpServletRequest request, @Valid UserDTO userDTO, Model model) {

        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        String name = userDTO.getName();
        String phone = userDTO.getPhone();

        String passHash = passwordEncoder.encodePassword(password, null);

        if ("".equals(email) ||
                !userService.addUser(email, passHash, name, phone, UserRole.USER)) {
            model.addAttribute("exists", true);
            model.addAttribute("email", email);
            return "sign_up";
        }
        authWithAuthManager(request, email, password);
        emailSenderService.sendWelcomeEmail(email);
        return "redirect:/";
    }

    public void authWithAuthManager(HttpServletRequest request, String username, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        authToken.setDetails(new WebAuthenticationDetails(request));

        Authentication authentication = authenticationManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public String editUser(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            UserAccount dbUser = userService.findByEmail(email);
            if (dbUser != null) {
                model.addAttribute("user", dbUser);
            }
        }
        return "edit_user";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String editUser(@Valid UserDTO userDTO) {
        userService.updateUser(userDTO);
        return "redirect:/";
    }

}
