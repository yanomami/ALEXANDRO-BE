package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.ClientRepository;
import com.jle.alexandro.dao.OrderHeaderRepository;
import com.jle.alexandro.dao.OrderLineRepository;
import com.jle.alexandro.models.OrderForm;
import com.jle.alexandro.models.ProductItemForm;
import com.jle.alexandro.models.entities.Client;
import com.jle.alexandro.models.entities.OrderHeader;
import com.jle.alexandro.models.entities.OrderLine;
import com.jle.alexandro.models.entities.ShippingMethod;
import com.jle.alexandro.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public OrderHeader saveOrder(OrderForm orderForm) {

        OrderHeader orderHeader = formatOrderHeader(orderForm);

        // Save orderHeader to data base
        OrderHeader orderHeaderSaved = orderHeaderRepository.save(orderHeader);

        // Save orderLines to data base
        ProductItemForm[] productItemsArray = orderForm.getProductItems();
//        for(ProductItemForm productItem : productItemsArray) {
//            OrderLine orderLine = new OrderLine();
//            orderLine.setOrderHeaderId(orderHeader.getId());
//            orderLine.setProductId(productItem.getId());
//            orderLine.setQuantity(productItem.getQuantity());
//
//            orderHeaderSaved.getOrderLinesById().add(orderLine);
//        }

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
        orderHeader.setDateShipped(new java.sql.Date(System.currentTimeMillis()));

        ShippingMethod shippingMethod = new ShippingMethod();
        shippingMethod.setId(1);
        shippingMethod.setDescription("DHL");
        shippingMethod.setCharges(new BigDecimal(18.4065));
        orderHeader.setShippingMethodByShippingMethodId(shippingMethod);

        return orderHeader;
    }

}
