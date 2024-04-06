package com.finalProject.applianceStore.applianceStore.controllers;

import com.finalProject.applianceStore.applianceStore.business.abstracts.OrderService;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.CreateOrderRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.GetOrderByUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.GetOrderRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.UpdateOrderRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.CreateOrderResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.GetOrderByUserResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.GetOrderResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.UpdateOrderResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    public OrderService orderService;
    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody @Valid CreateOrderRequest request) throws Exception {
        CreateOrderResponse createOrderResponse = orderService.createOrder(request);
        return ResponseEntity.ok(createOrderResponse);
    }
    @GetMapping
    public ResponseEntity<GetOrderResponse> getOrder(@RequestBody @Valid GetOrderRequest request) throws Exception {
        GetOrderResponse getOrderResponse = orderService.getOrder(request);
        return ResponseEntity.ok(getOrderResponse);
    }
    @GetMapping("/users/{email}")
    public ResponseEntity<List<GetOrderByUserResponse>> getOrderByUser(@RequestBody @Valid GetOrderByUserRequest request) throws Exception {
        List<GetOrderByUserResponse> getOrderByUserResponse = orderService.getOrderByUser(request);
        return ResponseEntity.ok(getOrderByUserResponse);
    }
    @PutMapping
    public ResponseEntity<UpdateOrderResponse> updateOrder(@RequestBody @Valid UpdateOrderRequest request) throws Exception {
        UpdateOrderResponse updateOrderResponse = orderService.updateOrder(request);

        return ResponseEntity.ok(updateOrderResponse);
    }

}
