package edu.store.controller;

import edu.store.dto.OrderDTO;
import edu.store.service.OrderService;
import edu.store.ui.Pages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrdersController {

    private final OrderService orderService;

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
        return Pages.PAGE_ORDERS;
    }

    @GetMapping("/orders/{status}")
    public String getOrdersStatus(@PathVariable String status, Model model) {
        model.addAttribute("orders", orderService.findOrdersByStatus(status));
        return Pages.PAGE_ORDERS;
    }

    @GetMapping(value = "/order/{id}")
    public String getOrderInfo(Model model, @PathVariable Long id) {
        model.addAttribute("order", orderService.findOrderById(id));
        return Pages.PAGE_ORDER_DETAILS;
    }
}
