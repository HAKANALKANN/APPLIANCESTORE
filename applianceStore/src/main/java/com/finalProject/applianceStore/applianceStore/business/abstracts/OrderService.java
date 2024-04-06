package com.finalProject.applianceStore.applianceStore.business.abstracts;

import com.finalProject.applianceStore.applianceStore.dtos.requests.order.CreateOrderRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.GetOrderByUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.GetOrderRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.order.UpdateOrderRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.CreateOrderResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.GetOrderByUserResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.GetOrderResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.order.UpdateOrderResponse;

import java.util.List;

public interface OrderService {
    CreateOrderResponse createOrder(CreateOrderRequest request) throws Exception;
    GetOrderResponse getOrder(GetOrderRequest request) throws Exception;
    List<GetOrderByUserResponse> getOrderByUser(GetOrderByUserRequest request) throws Exception;

    UpdateOrderResponse updateOrder(UpdateOrderRequest request) throws Exception;

}
