package ch.zhaw.ecotracker.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "customer", indexes = {
        @Index(name = "fk_customer_address1_idx", columnList = "fk_address")
})
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_address", nullable = false)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}