package ch.zhaw.ecotracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "monetary_value")
    private Double monetaryValue;

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", monetaryValue=" + monetaryValue +
                ", customer=" + customer +
                ", redeemed=" + redeemed +
                '}';
    }

    @JsonIgnoreProperties(value = {"coupons", "purchases"})
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "redeemed")
    private Boolean redeemed;

    public Boolean getRedeemed() {
        return redeemed;
    }

    public void setRedeemed(Boolean redeemed) {
        this.redeemed = redeemed;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(Double value) {
        this.monetaryValue = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
