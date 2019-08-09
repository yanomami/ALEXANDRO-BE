package com.jle.alexandro.models;

import com.jle.alexandro.models.entities.Client;
import com.jle.alexandro.models.entities.OrderLine;
import com.jle.alexandro.models.entities.ShippingMethod;
import lombok.Data;

@Data
public class OrderForm {

        private Client client;
        private ShippingMethod shippingMethod;
        private OrderLine[] orderlines;
}
