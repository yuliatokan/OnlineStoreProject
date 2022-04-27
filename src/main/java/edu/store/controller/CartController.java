package edu.store.controller;

import edu.store.ui.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart() {
        return Pages.PAGE_CART;
    }

    @GetMapping("/checkout")
    public String checkout(Model model, @RequestParam(name = "order") Long idOrder) {
        model.addAttribute("idOrder", idOrder);
        return Pages.PAGE_CHECKOUT;
    }

    @GetMapping("/liqpay")
    public String pay(Model model) {
        model.addAttribute("sum", 10);
        model.addAttribute("order", "dress");
        return Pages.PAGE_PAY;
    }
}
