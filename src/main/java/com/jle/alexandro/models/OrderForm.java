package com.jle.alexandro.models;

import com.jle.alexandro.models.entities.OrderLine;
import com.jle.alexandro.models.entities.ShippingMethod;
import lombok.Data;

@Data
public class OrderForm {

        private Integer idClient;
        private ShippingMethod shippingMethod;
        private OrderLine[] orderlines;
}
