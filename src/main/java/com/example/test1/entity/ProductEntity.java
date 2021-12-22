package com.example.test1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "product" )
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date_of_man")
    private Date date_of_man;

    @Column(name = "price")
    private int price;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<SaleEntity> sales;

    public ProductEntity() {
    }

    public ProductEntity(String name, String description, Date date_of_man, int price) {
        this.name = name;
        this.description = description;
        this.date_of_man = date_of_man;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_of_man() {
        return date_of_man;
    }

    public void setDate_of_man(Date date_of_man) {
        this.date_of_man = date_of_man;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
