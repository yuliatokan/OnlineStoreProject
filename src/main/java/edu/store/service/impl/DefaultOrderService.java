package edu.store.service.impl;

import edu.store.dto.OrderDTO;
import edu.store.entity.Order;
import edu.store.repository.OrderRepository;
import edu.store.service.OrderService;
import edu.store.utils.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(orderMapper::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderDTO findOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent())
            return null;
        return orderMapper.map(order.get());
    }

    @Override
    @Transactional
    public void updateOrdersStatus(Long id, String status) {
        Order order = orderRepository.findById(id).get();
        order.setStatus(status);
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public List<OrderDTO> findOrdersByStatus(String status) {
        List<Order> orders = orderRepository.findByStatus(status);

        return orders.stream().map(orderMapper::map).collect(Collectors.toList());
    }
}
