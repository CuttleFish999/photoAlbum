package com.photoalbum.dodo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proid")
    private Integer proid;
    @Column(name = "proname")
    private String proname;
    @Column(name = "procategory")
    private String procategory;
    @Column(name = "proimage")
    private byte[] proimage;
    @Column(name = "proprice")
    private Integer proprice;
    @Column(name = "prostock")
    private Integer prostock;
    @Column(name = "prodescription")
    private String prodescription;

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProcategory() {
        return procategory;
    }

    public void setProcategory(String procategory) {
        this.procategory = procategory;
    }

    public byte[] getProimage() {
        return proimage;
    }

    public void setProimage(byte[] proimage) {
        this.proimage = proimage;
    }

    public Integer getProprice() {
        return proprice;
    }

    public void setProprice(Integer proprice) {
        this.proprice = proprice;
    }

    public Integer getProstock() {
        return prostock;
    }

    public void setProstock(Integer prostock) {
        this.prostock = prostock;
    }

    public String getProdescription() {
        return prodescription;
    }

    public void setProdescription(String prodescription) {
        this.prodescription = prodescription;
    }
}