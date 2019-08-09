package com.jle.alexandro.services;

import com.jle.alexandro.models.OrderForm;
import com.jle.alexandro.models.entities.OrderHeader;

public interface OrderService {
    OrderHeader saveOrder(OrderForm orderForm);
}
