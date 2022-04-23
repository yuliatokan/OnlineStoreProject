package edu.store.service;

import edu.store.dto.OrderDTO;
import edu.store.entity.Order;
import edu.store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void addOrder (Order order) {
        orderRepository.save(order);
    }

    @Transactional
    public List<OrderDTO> getAllOrders(){
        final List<OrderDTO> result = new ArrayList<>();
        List<Order> orders = orderRepository.findAll();

        orders.forEach((x) -> result.add(x.toDTO()));
        return result;
    }

    @Transactional
    public OrderDTO findOrderById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent())
            return null;
        return order.get().toDTO();
    }

    @Transactional
    public void updateOrdersStatus(Long id, String status){
        Order order = orderRepository.findById(id).get();
        order.setStatus(status);
        orderRepository.save(order);
    }

    @Transactional
    public List<OrderDTO> findOrdersByStatus(String status){
        final List<OrderDTO> result = new ArrayList<>();
        List<Order> orders = orderRepository.findByStatus(status);

        orders.forEach((x) -> result.add(x.toDTO()));
        return result;
    }
}
