package ch.zhaw.ecotracker.entities;

import javax.persistence.*;

@Table(name = "product", indexes = {
        @Index(name = "fk_product_supplier1_idx", columnList = "fk_supplier")
})
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "co2emission")
    private Integer co2emission;

    @ManyToOne
    @JoinColumn(name = "fk_supplier")
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public Integer getCo2emission() {
        return co2emission;
    }

    public void setCo2emission(Integer co2emission) {
        this.co2emission = co2emission;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}