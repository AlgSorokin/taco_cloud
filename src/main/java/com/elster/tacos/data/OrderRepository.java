package com.elster.tacos.data;

import com.elster.tacos.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
