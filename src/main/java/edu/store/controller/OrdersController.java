package edu.store.controller;

import edu.store.dto.OrderDTO;
import edu.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String orders(@RequestParam(name = "search", required = false) String search, Model model) {
        if (search == null || search.isEmpty()) {
            model.addAttribute("orders", orderService.getAllOrders());
        } else {
            model.addAttribute("search", search);
            try {
                Long id = Long.parseLong(search);
                OrderDTO orderDTO = orderService.findOrderById(id);
                List<OrderDTO> orders = new ArrayList<>();
                if (orderDTO != null)
                    orders.add(orderDTO);
                model.addAttribute("orders", orders);
            } catch (Exception e) {
                model.addAttribute("number", false);
            }
        }
        return "orders";
    }

    @GetMapping("/orders/{status}")
    public String orders_status(@PathVariable String status, Model model) {
        model.addAttribute("orders", orderService.findOrdersByStatus(status));
        return "orders";
    }

    @GetMapping(value = "/order/{id}")
    public String orderInfo(Model model, @PathVariable Long id) {
        model.addAttribute("order", orderService.findOrderById(id));
        return "order_details";
    }
}
