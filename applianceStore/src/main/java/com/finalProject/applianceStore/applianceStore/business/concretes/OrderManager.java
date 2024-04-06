package com.finalProject.applianceStore.applianceStore.business.concretes;

import com.finalProject.applianceStore.applianceStore.business.abstracts.CartService;
import com.finalProject.applianceStore.applianceStore.business.abstracts.OrderService;
import com.finalProject.applianceStore.applianceStore.business.abstracts.UserService;
import com.finalProject.applianceStore.applianceStore.core.utilities.mapping.ModelMapperService;
import com.finalProject.applianceStore.applianceStore.dataaccess.*;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.CreateOrderRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.GetOrderByUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.GetOrderRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.UpdateOrderRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.CreateOrderResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.GetOrderByUserResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.GetOrderResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.UpdateOrderResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.orderItem.OrderItemResponse;
import com.finalProject.applianceStore.applianceStore.entities.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class OrderManager implements OrderService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public CartRepository cartRepository;
    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public PaymentRepository paymentRepository;
    @Autowired
    public OrderItemRepository orderItemRepository;
    @Autowired
    public CartItemRepository cartItemRepository;
    @Autowired
    public UserService userService;
    @Autowired
    public CartService cartService;
    @Autowired
    public ModelMapperService modelMapperService;

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) throws Exception {
//       Order order  = modelMapperService.forRequest().map(request, Order.class);
        Cart cart1 = cartRepository.findCartByEmailAndCartId(request.getEmail(), request.getCartId());
        if (cart1==null){
            throw new Exception("Cart not found");
        }
        Order order = new Order();

        order.setEmail(request.getEmail());
        order.setOrderDate(LocalDate.now());
        order.setTotalAmount(cart1.getTotalPrice());
        order.setOrderStatus("Order Accepted !");
        orderRepository.save(order);
        Payment payment = new Payment();
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setOrder(order);
        payment.setPaymentId(payment.getPaymentId());
        paymentRepository.save(payment);

        List<CartItem> cartItems = cart1.getCartItems();
        if (cartItems.isEmpty()){
            throw new Exception("Cart is empty");
        }
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem cartItem:cartItems){
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setDiscount(cartItem.getDiscount());
            orderItem.setOrderedProductPrice(cartItem.getProductPrice());
            orderItem.setOrder(order);

            orderItems.add(orderItem);
        }
        orderItems = orderItemRepository.saveAll(orderItems);

        cartItems.forEach(item -> {
            int quantity = item.getQuantity();
            Product product = item.getProduct();
            cartItemRepository.deleteCartItemByProductIdAndCartId(product.getProductId(), request.getCartId());
            product.setQuantity(product.getQuantity() - quantity);
        });
        CreateOrderResponse createOrderResponse = modelMapperService.forResponse().map(order,CreateOrderResponse.class);
        List<OrderItemResponse> orderItemResponses = new ArrayList<>();
        orderItems.forEach(item->modelMapperService.forResponse().map(item, OrderItemResponse.class));

        return createOrderResponse;


    }

    @Override
    public GetOrderResponse getOrder(GetOrderRequest request) throws Exception {
        Order order = modelMapperService.forRequest().map(request,Order.class);
        Order order1 =orderRepository.findOrderByEmailAndOrderId(request.getEmail(),request.getOrderId());
        if (order1==null){
            throw new Exception("Order not found");
        }

        GetOrderResponse getOrderResponse = modelMapperService.forResponse().map(order1,GetOrderResponse.class);
        return getOrderResponse;
    }

    @Override
    public List<GetOrderByUserResponse> getOrderByUser(GetOrderByUserRequest request) throws Exception {

        Order order = modelMapperService.forRequest().map(request,Order.class);
        List<Order> orders= orderRepository.findAllByEmail(request.getEmail());

        List<GetOrderByUserResponse> result = orders.stream().map(order1 -> modelMapperService.forResponse().map(order1, GetOrderByUserResponse.class)).collect(Collectors.toList());
        if (result.size()==0){
            throw new Exception("No orders placed yet by the user with email: " + request.getEmail());
        }
        return result;
    }

    @Override
    public UpdateOrderResponse updateOrder(UpdateOrderRequest request) throws Exception {
        Order order = modelMapperService.forRequest().map(request,Order.class);
        Order order1 = orderRepository.findOrderByEmailAndOrderId(request.getEmail(), request.getOrderId());
        if (order1==null){
            throw new Exception("Order not found.");
        }
        order1.setOrderStatus(order1.getOrderStatus());
        UpdateOrderResponse result = modelMapperService.forResponse().map(order1, UpdateOrderResponse.class);

        return result;
    }
}
