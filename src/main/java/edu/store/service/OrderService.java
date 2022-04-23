package edu.store.service;

import edu.store.dto.OrderDTO;
import edu.store.entity.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {
    @Transactional
    void addOrder(Order order);

    @Transactional
    List<OrderDTO> getAllOrders();

    @Transactional
    OrderDTO findOrderById(Long id);

    @Transactional
    void updateOrdersStatus(Long id, String status);

    @Transactional
    List<OrderDTO> findOrdersByStatus(String status);
}
