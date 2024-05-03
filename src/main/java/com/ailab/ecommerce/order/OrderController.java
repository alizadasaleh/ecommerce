package com.ailab.ecommerce.order;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
        return  ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody @Valid OrderRequestCreateDto orderRequestCreateDto){
        return ResponseEntity.ok(orderService.createOrder(orderRequestCreateDto));
    }

    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<List<OrderResponseDto>> getAllOrdersByCustomer(@PathVariable("customerId") Long customerId){
        return  ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId));
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable("id") Long id,@RequestBody @Valid OrderRequestCreateDto orderRequestCreateDto){
        return ResponseEntity.ok(orderService.updateOrder(id, orderRequestCreateDto));
    }
    @GetMapping("/products/{productId}/orders")
    public ResponseEntity<List<OrderResponseDto>> getOrderByProductId(@PathVariable ("productId") Long productId){
        return ResponseEntity.ok(orderService.getOrdersByProductId(productId));
    }

}
