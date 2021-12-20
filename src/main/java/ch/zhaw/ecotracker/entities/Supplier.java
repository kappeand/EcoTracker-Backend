package ch.zhaw.ecotracker.entities;

import javax.persistence.*;

@Table(name = "supplier", indexes = {
        @Index(name = "fk_supplier_address1_idx", columnList = "fk_address")
})
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_address", nullable = false)
    private Address address;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
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