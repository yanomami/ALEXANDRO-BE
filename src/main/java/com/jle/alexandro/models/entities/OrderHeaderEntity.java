package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_header", schema = "dbo", catalog = "DB_ALEXANDRIA")
public class OrderHeaderEntity {
    private Integer idOrderHeader;
    private Date datePlaced;
    private Date dateShipped;
    private Date dateDelivered;
    private String comment;
    private ClientEntity clientByClientId;
    private ShippingMethodEntity shippingMethodByShippingMethodId;
    private Set<OrderLineEntity> orderLinesByIdOrderHeader;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_header", nullable = false)
    public Integer getIdOrderHeader() {
        return idOrderHeader;
    }

    public void setIdOrderHeader(Integer idOrderHeader) {
        this.idOrderHeader = idOrderHeader;
    }

    @Basic
    @Column(name = "date_placed", nullable = false)
    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }

    @Basic
    @Column(name = "date_shipped", nullable = true)
    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    @Basic
    @Column(name = "date_delivered", nullable = true)
    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderHeaderEntity that = (OrderHeaderEntity) o;
        return Objects.equals(idOrderHeader, that.idOrderHeader) &&
                Objects.equals(datePlaced, that.datePlaced) &&
                Objects.equals(dateShipped, that.dateShipped) &&
                Objects.equals(dateDelivered, that.dateDelivered) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrderHeader, datePlaced, dateShipped, dateDelivered, comment);
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id_client", nullable = false)
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "shipping_method_id", referencedColumnName = "id_shipping_method", nullable = false)
    public ShippingMethodEntity getShippingMethodByShippingMethodId() {
        return shippingMethodByShippingMethodId;
    }

    public void setShippingMethodByShippingMethodId(ShippingMethodEntity shippingMethodByShippingMethodId) {
        this.shippingMethodByShippingMethodId = shippingMethodByShippingMethodId;
    }

    @OneToMany(mappedBy = "orderHeaderByOrderHeaderId")
    public Set<OrderLineEntity> getOrderLinesByIdOrderHeader() {
        return orderLinesByIdOrderHeader;
    }

    public void setOrderLinesByIdOrderHeader(Set<OrderLineEntity> orderLinesByIdOrderHeader) {
        this.orderLinesByIdOrderHeader = orderLinesByIdOrderHeader;
    }
}
