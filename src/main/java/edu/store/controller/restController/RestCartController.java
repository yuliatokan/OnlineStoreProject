package edu.store.controller.restController;

import edu.store.dto.ResultDTO;
import edu.store.entity.*;
import edu.store.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class RestCartController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSizeService productSizeService;

    @Autowired
    private OrderedProductService orderedProductService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/buy")
    public int buy(@RequestParam(name = "productId", required = false) Long productId,
                                         @RequestParam(name = "sizeId", required = false) Long sizeId,
                                         HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        CartItem cartItem = new CartItem(cart, productService.getProduct(productId), productSizeService.findProductById(sizeId), 1);
        cart.setCartItem(cartItem);
        return cart.getCartItems().size();
    }

    @PostMapping(value = "/remove_item")
    public ResponseEntity<ResultDTO> delete(@RequestParam(name = "productId", required = false) Long productId, HttpSession session) {
        if (productId != null && productId > 0) {
            Cart cart = (Cart) session.getAttribute("cart");
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getId() == productId) {
                    cartItems.remove(cartItem);
                    break;
                }
            }
            cart.setCartItems(cartItems);
        }
        return new ResponseEntity<>(new ResultDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/quantity")
    public ResponseEntity<ResultDTO> delete(@RequestParam(name = "productId", required = false) Long productId, @RequestParam(name = "quantity", required = false) int quantity, HttpSession session) {
        if (productId != null && productId > 0) {
            Cart cart = (Cart) session.getAttribute("cart");
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getId() == productId) {
                    cartItem.setQuantity(quantity);
                    break;
                }
            }
            cart.setCartItems(cartItems);
        }
        return new ResponseEntity<>(new ResultDTO(), HttpStatus.OK);
    }

    @PostMapping("/checkout")
    public Long checkout(HttpSession session, @RequestParam(name = "phone") String phone, @RequestParam(name = "address") String address, @RequestParam(name = "delivery") String delivery) {
        Cart cart = (Cart) session.getAttribute("cart");
        Set<OrderedProduct> orderedProducts = new HashSet<>(0);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            OrderedProduct orderedProduct = new OrderedProduct(cartItem.getProduct(), cartItem.getProductSize(), cartItem.getQuantity());
            orderedProductService.addOrderedProduct(orderedProduct);
            orderedProducts.add(orderedProduct);
        }
        Long idOrder = createOrder(orderedProducts, phone, address, delivery);
        session.setAttribute("cart", new Cart());
        return idOrder;
    }

    private Long createOrder(Set<OrderedProduct> orderedProducts, String phone, String address, String delivery) {
        UserAccount user = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            user = userService.findByEmail(email);
        }
        Date date = new Date();
        Order order = new Order(user, orderedProducts, date, "New", phone, address, delivery);
        orderService.addOrder(order);
        return order.getId();
    }

    @PostMapping("/update_status")
    public void updateStatus(@RequestParam(value = "id") Long id, @RequestParam(value = "status") String status) {
        orderService.updateOrdersStatus(id, status);
    }
}
