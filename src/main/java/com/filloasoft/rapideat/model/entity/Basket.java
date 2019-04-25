package com.filloasoft.rapideat.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Adrian
 */
@Entity
public class Basket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "basket")
    private List<BasketProduct> productList;

    public Basket() {
        productList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BasketProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<BasketProduct> productList) {
        this.productList = productList;
    }
}