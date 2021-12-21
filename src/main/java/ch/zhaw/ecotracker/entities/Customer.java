package ch.zhaw.ecotracker.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_address")
    private Address address;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "co2rating", length = 45)
    private String co2rating;

    @ManyToMany
    @JoinTable(name = "customer_has_product",
            joinColumns = @JoinColumn(name = "fk_customer"),
            inverseJoinColumns = @JoinColumn(name = "fk_product"))
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCo2rating() {
        return co2rating;
    }

    public void setCo2rating(String co2rating) {
        this.co2rating = co2rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address fkAddress) {
        this.address = fkAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}