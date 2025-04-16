package com.avilatek.ecommerceapi.service.order;

import com.avilatek.ecommerceapi.dto.OrderDto;
import com.avilatek.ecommerceapi.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);
    OrderDto convertToDto(Order order);
}