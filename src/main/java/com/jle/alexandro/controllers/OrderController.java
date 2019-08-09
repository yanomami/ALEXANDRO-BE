package com.jle.alexandro.controllers;

import com.jle.alexandro.models.OrderForm;
import com.jle.alexandro.models.entities.OrderHeader;
import com.jle.alexandro.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public OrderHeader saveOrder(@RequestBody OrderForm orderForm)  {
        return orderService.saveOrder(orderForm);
    }
}
