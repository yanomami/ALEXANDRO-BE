package com.jle.alexandro.models;

import lombok.Data;

@Data
public class OrderForm {

        private Integer idClient;
        private ProductItemForm[] productItems;
}
