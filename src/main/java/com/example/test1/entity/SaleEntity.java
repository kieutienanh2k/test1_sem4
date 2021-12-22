package com.example.test1.entity;

import javax.persistence.*;

@Entity
@Table(name="sale")
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sale_man_id")
    private int sale_man_id;

    @Column(name = "product_id")
    private int product_id;

    @Column(name = "name")
    private String name;

    @Column(name = "dos")
    private int dos;

    @ManyToOne() //EAGER
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    public SaleEntity() {
    }

    public SaleEntity(Integer sale_man_id, Integer product_id, String name, Integer dos, ProductEntity product) {
        this.sale_man_id = sale_man_id;
        this.product_id = product_id;
        this.name = name;
        this.dos = dos;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSale_man_id() {
        return sale_man_id;
    }

    public void setSale_man_id(Integer sale_man_id) {
        this.sale_man_id = sale_man_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDos() {
        return dos;
    }

    public void setDos(Integer dos) {
        this.dos = dos;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
