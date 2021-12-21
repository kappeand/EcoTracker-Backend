package ch.zhaw.ecotracker.entities;

import javax.persistence.*;

@Table(name = "supplier")
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_address")
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