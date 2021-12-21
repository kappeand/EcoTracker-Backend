package ch.zhaw.ecotracker.entities;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Entity
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "co2_rating")
    private String co2rating;

    @Column(name = "cumulus_number")
    private Integer cumulusNumber;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<Coupon> coupons = new ArrayList<>();

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "customer_friends",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "friends_id"))
    private Set<Customer> friends = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Customer> getFriends() {
        return friends;
    }

    public void setFriends(Set<Customer> customers) {
        this.friends = customers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Integer getCumulusNumber() {
        return cumulusNumber;
    }

    public void setCumulusNumber(Integer cumulusNumber) {
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
