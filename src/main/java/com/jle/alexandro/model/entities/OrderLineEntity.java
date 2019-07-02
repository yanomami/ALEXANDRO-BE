package com.jle.alexandro.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_line", schema = "dbo", catalog = "DB_ALEXANDRIA")
@IdClass(OrderLineEntityPK.class)
public class OrderLineEntity {
    private Integer orderHeaderId;
    private Integer productId;
    private Integer quantity;
    private OrderHeaderEntity orderHeaderByOrderHeaderId;
    private ProductEntity productByProductId;

    @Id
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
        OrderLineEntity that = (OrderLineEntity) o;
        return Objects.equals(orderHeaderId, that.orderHeaderId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderHeaderId, productId, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "order_header_id", referencedColumnName = "id_order_header", nullable = false, insertable = false, updatable = false)
    public OrderHeaderEntity getOrderHeaderByOrderHeaderId() {
        return orderHeaderByOrderHeaderId;
    }

    public void setOrderHeaderByOrderHeaderId(OrderHeaderEntity orderHeaderByOrderHeaderId) {
        this.orderHeaderByOrderHeaderId = orderHeaderByOrderHeaderId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id_product", nullable = false, insertable = false, updatable = false)
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
}
