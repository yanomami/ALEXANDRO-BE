package com.jle.alexandro.models;

import com.jle.alexandro.models.entities.Client;
import lombok.Data;

@Data
public class OrderForm {

        private Client client;
        private ProductItemForm[] productItems;
}
