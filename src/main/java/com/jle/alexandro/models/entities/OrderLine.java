package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_line", schema = "dbo", catalog = "DB_ALEXANDRO")
@IdClass(OrderLinePK.class)
public class OrderLine {
    private Integer orderHeaderId;
    private Integer productId;
    private Integer quantity;
    private OrderHeader orderHeaderByOrderHeaderId;
    private Product productByProductId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_header_id", nullable = false)
    public Integer getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(Integer orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    @Id
    @Column(name = "product_id", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(orderHeaderId, orderLine.orderHeaderId) &&
                Objects.equals(productId, orderLine.productId) &&
                Objects.equals(quantity, orderLine.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderHeaderId, productId, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "order_header_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public OrderHeader getOrderHeaderByOrderHeaderId() {
        return orderHeaderByOrderHeaderId;
    }

    public void setOrderHeaderByOrderHeaderId(OrderHeader orderHeaderByOrderHeaderId) {
        this.orderHeaderByOrderHeaderId = orderHeaderByOrderHeaderId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
