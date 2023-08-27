package ru.market.orderservice.service;

import org.springframework.stereotype.Service;
import ru.market.orderservice.dto.OrderLineItemsDto;
import ru.market.orderservice.dto.OrderRequest;
import ru.market.orderservice.model.Order;
import ru.market.orderservice.model.OrderLineItems;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
