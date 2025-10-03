package com.example.shop.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Long createOrder(OrderCreateRequest request) {
        Order existingOrder=orderRepository.(findById(request.getOrderId());
        if (existingOrder != null){
            throw new RuntimeException("Order already exists");
        }
        Order order=new Order(
                request.getOrderId(),
                request.getOrderBody()
        );
        orderRepository.save(order);
        return order.getId();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findALl();
    }

    public Order findById(Long id) {
        Order order=orderRepository.findById(id);
        if(order==null){
            throw new RuntimeException("Order not found");
        }
        return order;
    }

    public void deleteOrder(Long id) {
        Order order=orderRepository.findById(id);
        if(order==null){
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(id);
    }
}
