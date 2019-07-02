package com.jle.alexandro.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "client", schema = "dbo", catalog = "DB_ALEXANDRIA")
public class ClientEntity {
    private Integer idClient;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private TitleEntity titleByTitleId;
    private AddressEntity addressByInvoiceAddressId;
    private AddressEntity addressByDeliveryAddressId;
    private PaymentMethodEntity paymentMethodByPaymentMethodId;
    private Set<OrderHeaderEntity> orderHeadersByIdClient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(idClient, that.idClient) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, firstName, lastName, email, phone, password);
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "title_id", referencedColumnName = "id_title", nullable = false)
    public TitleEntity getTitleByTitleId() {
        return titleByTitleId;
    }

    public void setTitleByTitleId(TitleEntity titleByTitleId) {
        this.titleByTitleId = titleByTitleId;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "invoice_address_id", referencedColumnName = "id_address", nullable = false)
    public AddressEntity getAddressByInvoiceAddressId() {
        return addressByInvoiceAddressId;
    }

    public void setAddressByInvoiceAddressId(AddressEntity addressByInvoiceAddressId) {
        this.addressByInvoiceAddressId = addressByInvoiceAddressId;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "delivery_address_id", referencedColumnName = "id_address", nullable = false)
    public AddressEntity getAddressByDeliveryAddressId() {
        return addressByDeliveryAddressId;
    }

    public void setAddressByDeliveryAddressId(AddressEntity addressByDeliveryAddressId) {
        this.addressByDeliveryAddressId = addressByDeliveryAddressId;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id_payment_method", nullable = false)
    public PaymentMethodEntity getPaymentMethodByPaymentMethodId() {
        return paymentMethodByPaymentMethodId;
    }

    public void setPaymentMethodByPaymentMethodId(PaymentMethodEntity paymentMethodByPaymentMethodId) {
        this.paymentMethodByPaymentMethodId = paymentMethodByPaymentMethodId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "clientByClientId")
    public Set<OrderHeaderEntity> getOrderHeadersByIdClient() {
        return orderHeadersByIdClient;
    }

    public void setOrderHeadersByIdClient(Set<OrderHeaderEntity> orderHeadersByIdClient) {
        this.orderHeadersByIdClient = orderHeadersByIdClient;
    }
}
