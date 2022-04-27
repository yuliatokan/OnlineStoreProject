package edu.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model, @RequestParam(name = "order") Long idOrder) {
        model.addAttribute("idOrder", idOrder);
        return "checkout";
    }

    @GetMapping("/liqpay")
    public String pay(Model model) {
        model.addAttribute("sum", 10);
        model.addAttribute("order", "dress");
        return "liqpay";
    }
}
