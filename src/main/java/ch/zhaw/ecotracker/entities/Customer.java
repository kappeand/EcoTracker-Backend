package ch.zhaw.ecotracker.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer extends Person {

    @Column(name = "co2_rating")
    private String co2rating;

    @Column(name = "cumulus_number")
    private String cumulusNumber;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<Coupon> coupons = new ArrayList<>();

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public String getCumulusNumber() {
        return cumulusNumber;
    }

    public void setCumulusNumber(String cumulusNumber) {
        this.cumulusNumber = cumulusNumber;
    }

    public String getCo2rating() {
        return co2rating;
    }

    public void setCo2rating(String co2rating) {
        this.co2rating = co2rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return getId() != null && Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
