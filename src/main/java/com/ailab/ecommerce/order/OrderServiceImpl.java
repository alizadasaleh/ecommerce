package com.ailab.ecommerce.order;

import com.ailab.ecommerce.customer.Customer;
import com.ailab.ecommerce.customer.CustomerRepository;
import com.ailab.ecommerce.product.Product;
import com.ailab.ecommerce.product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public OrderResponseDto createOrder(OrderRequestCreateDto orderRequestCreateDto) {
        Customer customer=customerRepository.findById(orderRequestCreateDto.getCustomerId())
                .orElse(null)  ;
        Order order = new Order();
        order.setCustomer(customer);
        List<Product> products = productRepository.findAllById(orderRequestCreateDto.getProductIds());
        order.setProducts(products);
        order = orderRepository.save(order);
        return orderMapper.toResponseDto(order);
    }


    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public OrderResponseDto getOrder(Long orderId) {
        return orderMapper.toResponseDto(orderRepository.findById(orderId).orElse(null));
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResponseDto> getOrdersByCustomerId(String customerId) {
        return List.of();
    }

    @Override
    public List<OrderResponseDto> getOrdersByProductId(String productId) {
        return List.of();
    }




}
