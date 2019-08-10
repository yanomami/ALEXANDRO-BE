package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_header", schema = "dbo", catalog = "DB_ALEXANDRO")
public class OrderHeader {
    private Integer id;
    private Date datePlaced;
    private Date dateShipped;
    private Date dateDelivered;
    private String comment;
    private Client clientByClientId;
    private ShippingMethod shippingMethodByShippingMethodId;
    private Set<OrderLine> orderLinesById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Lob
    @Column(name = "comment", nullable = true, length = -1, columnDefinition = "TEXT")
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
        OrderHeader that = (OrderHeader) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(datePlaced, that.datePlaced) &&
                Objects.equals(dateShipped, that.dateShipped) &&
                Objects.equals(dateDelivered, that.dateDelivered) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datePlaced, dateShipped, dateDelivered, comment);
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "shipping_method_id", referencedColumnName = "id", nullable = false)
    public ShippingMethod getShippingMethodByShippingMethodId() {
        return shippingMethodByShippingMethodId;
    }

    public void setShippingMethodByShippingMethodId(ShippingMethod shippingMethodByShippingMethodId) {
        this.shippingMethodByShippingMethodId = shippingMethodByShippingMethodId;
    }

    @OneToMany(mappedBy = "orderHeaderByOrderHeaderId", cascade = CascadeType.REMOVE)
    public Set<OrderLine> getOrderLinesById() {
        return orderLinesById;
    }

    public void setOrderLinesById(Set<OrderLine> orderLinesById) {
        this.orderLinesById = orderLinesById;
    }
}
