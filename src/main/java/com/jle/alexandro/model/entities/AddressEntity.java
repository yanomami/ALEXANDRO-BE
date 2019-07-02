package com.jle.alexandro.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "address", schema = "dbo", catalog = "DB_ALEXANDRIA")
public class AddressEntity {
    private Integer idAddress;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private CountryEntity countryByCountryId;
    private Set<ClientEntity> clientsByIdAddress;
    private Set<ClientEntity> clientsByIdAddress_0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address", nullable = false)
    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    @Basic
    @Column(name = "address_line_1", nullable = false, length = 255)
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Basic
    @Column(name = "address_line_2", nullable = true, length = 255)
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 45)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "postal_code", nullable = false, length = 10)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(idAddress, that.idAddress) &&
                Objects.equals(addressLine1, that.addressLine1) &&
                Objects.equals(addressLine2, that.addressLine2) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(postalCode, that.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddress, addressLine1, addressLine2, city, state, postalCode);
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id_country", nullable = false)
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "addressByInvoiceAddressId")
    public Set<ClientEntity> getClientsByIdAddress() {
        return clientsByIdAddress;
    }

    public void setClientsByIdAddress(Set<ClientEntity> clientsByIdAddress) {
        this.clientsByIdAddress = clientsByIdAddress;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "addressByDeliveryAddressId")
    public Set<ClientEntity> getClientsByIdAddress_0() {
        return clientsByIdAddress_0;
    }

    public void setClientsByIdAddress_0(Set<ClientEntity> clientsByIdAddress_0) {
        this.clientsByIdAddress_0 = clientsByIdAddress_0;
    }
}
