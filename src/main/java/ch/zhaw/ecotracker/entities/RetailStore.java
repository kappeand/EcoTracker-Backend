package ch.zhaw.ecotracker.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "retail_store")
@Entity
public class RetailStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_retail_store", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_address", nullable = false)
    private Address address;

    @Column(name = "store_manager", length = 45)
    private String storeManager;

    @Column(name = "deputy_retail_store_manager", length = 45)
    private String deputyRetailStoreManager;

    @ManyToMany
    @JoinTable(name = "retail_store_has_product",
            joinColumns = @JoinColumn(name = "fk_retail_store"),
            inverseJoinColumns = @JoinColumn(name = "fk_product"))
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getDeputyRetailStoreManager() {
        return deputyRetailStoreManager;
    }

    public void setDeputyRetailStoreManager(String deputyRetailStoreManager) {
        this.deputyRetailStoreManager = deputyRetailStoreManager;
    }

    public String getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(String storeManager) {
        this.storeManager = storeManager;
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