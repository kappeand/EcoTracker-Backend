package ch.zhaw.ecotracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Manager extends Person {

    @Column(name = "signature_authorized")
    private Boolean signatureAuthorized;

    @Column(name = "contact_person")
    private Boolean contactPerson;

    @JsonIgnoreProperties(value = "managers")
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Boolean getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Boolean contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Boolean getSignatureAuthorized() {
        return signatureAuthorized;
    }

    public void setSignatureAuthorized(Boolean signatureAuthorized) {
        this.signatureAuthorized = signatureAuthorized;
    }
}
