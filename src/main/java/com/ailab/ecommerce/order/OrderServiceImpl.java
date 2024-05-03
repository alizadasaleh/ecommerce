package com.ailab.ecommerce.order;

import com.ailab.ecommerce.customer.Customer;
import com.ailab.ecommerce.customer.CustomerRepository;
import com.ailab.ecommerce.exception.EntityNotFoundException;
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
                .orElseThrow(() -> new EntityNotFoundException("Customer not found to create order"));
        Order order = new Order();
        order.setCustomer(customer);
        List<Product> products = productRepository.findAllById(orderRequestCreateDto.getProductIds());
        if (products.isEmpty()) {
            throw new EntityNotFoundException("Product not found to create order");
        }
        order.setProducts(products);
        order = orderRepository.save(order);
        return orderMapper.toResponseDto(order);
    }


    @Override
    @Transactional
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Order not found to delete order"));
        orderRepository.delete(order);
    }

    @Override
    public OrderResponseDto getOrder(Long orderId) {
        return orderMapper.toResponseDto(orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException(Order.class,orderId)));
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toResponseDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<OrderResponseDto> getOrdersByCustomerId(Long customerId) {
        customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found to create order"));

        List<Order> orders = orderRepository.findAllByCustomerId(customerId);

        return orders.stream()
                .map(orderMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResponseDto> getOrdersByProductId(Long productId) {
        productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found to create order"));
        List<Order> orders = orderRepository.findAllByProductsId(productId);

        return orders.stream()
                .map(orderMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderResponseDto updateOrder(Long id, OrderRequestCreateDto orderRequestCreateDto) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Order.class,id));
        Customer customer=customerRepository.findById(orderRequestCreateDto.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found to create order"));

        order.setCustomer(customer);
        List<Product> products = productRepository.findAllById(orderRequestCreateDto.getProductIds());
        if (products.isEmpty()) {
            throw new EntityNotFoundException("Product not found to create order");
        }
        order.setProducts(products);
        order = orderRepository.save(order);
        return orderMapper.toResponseDto(order);
    }

}
