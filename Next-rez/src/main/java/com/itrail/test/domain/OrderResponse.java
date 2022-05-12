
package com.itrail.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
/**
 * @author barysevich_k
 */
@ApiModel(description = "Ответ по заказам")
public class OrderResponse {
    @ApiModelProperty(value = " Список заказов ", name = "orders")
    private List<Order> orders;

    public OrderResponse() {
    }
    
    public OrderResponse(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
