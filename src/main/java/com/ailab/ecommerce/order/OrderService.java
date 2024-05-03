package com.ailab.ecommerce.order;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestCreateDto orderRequestCreateDto);
    void deleteOrder(Long orderId);
    OrderResponseDto getOrder(Long orderId);
    List<OrderResponseDto> getAllOrders();
    List<OrderResponseDto> getOrdersByCustomerId(Long customerId);
    List<OrderResponseDto> getOrdersByProductId(Long productId);
}
