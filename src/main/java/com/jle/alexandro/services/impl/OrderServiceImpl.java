package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.OrderHeaderRepository;
import com.jle.alexandro.dao.OrderLineRepository;
import com.jle.alexandro.models.OrderForm;
import com.jle.alexandro.models.entities.Client;
import com.jle.alexandro.models.entities.OrderHeader;
import com.jle.alexandro.models.entities.OrderLine;
import com.jle.alexandro.models.entities.ShippingMethod;
import com.jle.alexandro.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Override
    public OrderHeader saveOrder(OrderForm orderForm) {

        Client client = formatClient(orderForm);
        OrderLine[] orderlinesArray = formatOrderLines(orderForm);
        OrderHeader orderHeader = formatOrderHeader(orderForm, client);

        orderHeader.setClientByClientId(orderForm.getClient());

        OrderHeader orderHeaderSaved = orderHeaderRepository.save(orderHeader);
        for(OrderLine orderLine : orderlinesArray) {
            orderHeaderSaved.getOrderLinesById().add(orderLine);
        }
        return orderHeaderSaved;
    }

    private Client formatClient(OrderForm orderForm) {
        Client client = new Client();
        client = orderForm.getClient();
        return client;
    }

    private OrderHeader formatOrderHeader(OrderForm orderForm, Client client) {
        OrderHeader orderHeader = new OrderHeader();

        orderHeader.setComment("comment");
        orderHeader.setDateDelivered(new java.sql.Date(System.currentTimeMillis()));
        orderHeader.setDatePlaced(new java.sql.Date(System.currentTimeMillis()));
        orderHeader.setDateDelivered(new java.sql.Date(System.currentTimeMillis()));

        ShippingMethod shippingMethod = new ShippingMethod();
        shippingMethod.setId(1);
        shippingMethod.setDescription("DHL");
        shippingMethod.setCharges(new BigDecimal(18.4065));
        orderHeader.setShippingMethodByShippingMethodId(shippingMethod);

        orderHeader.setClientByClientId(client);

        return orderHeader;
    }

    private OrderLine[] formatOrderLines(OrderForm orderForm) {
        OrderLine[] orderlinesArray = orderForm.getOrderlines();
        Set orderlinesSet = new HashSet<OrderLine>(Arrays.asList(orderlinesArray));
        return orderlinesArray;
    }

}
