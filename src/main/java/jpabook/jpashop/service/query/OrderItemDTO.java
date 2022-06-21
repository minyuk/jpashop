package jpabook.jpashop.service.query;

import jpabook.jpashop.domain.OrderItem;
import lombok.Getter;

@Getter
public class OrderItemDTO {

    private String itemName;
    private int orderPrice;
    private int count;

    public OrderItemDTO(OrderItem orderItem) {
        itemName = orderItem.getItem().getName();
        orderPrice = orderItem.getItem().getPrice();
        count = orderItem.getCount();
    }
}
