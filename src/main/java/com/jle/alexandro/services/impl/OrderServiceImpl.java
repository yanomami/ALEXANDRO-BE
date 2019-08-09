package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.ClientRepository;
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

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public OrderHeader saveOrder(OrderForm orderForm) {

        OrderHeader orderHeader = formatOrderHeader(orderForm);

        // Save to data base
        OrderHeader orderHeaderSaved = orderHeaderRepository.save(orderHeader);
        OrderLine[] orderlinesArray = orderForm.getOrderlines();
        for(OrderLine orderLine : orderlinesArray) {
            orderHeaderSaved.getOrderLinesById().add(orderLine);
        }
        return orderHeaderSaved;
    }

    private OrderHeader formatOrderHeader(OrderForm orderForm) {
        OrderHeader orderHeader = new OrderHeader();

        Optional<Client> optional = clientRepository.findById(orderForm.getIdClient());
        Client client = optional.orElse(null);
        orderHeader.setClientByClientId(client);

        orderHeader.setComment("comment");
        orderHeader.setDateDelivered(new java.sql.Date(System.currentTimeMillis()));
        orderHeader.setDatePlaced(new java.sql.Date(System.currentTimeMillis()));
        orderHeader.setDateDelivered(new java.sql.Date(System.currentTimeMillis()));

        ShippingMethod shippingMethod = new ShippingMethod();
        shippingMethod.setId(1);
        shippingMethod.setDescription("DHL");
        shippingMethod.setCharges(new BigDecimal(18.4065));
        orderHeader.setShippingMethodByShippingMethodId(shippingMethod);

        return orderHeader;
    }

}
