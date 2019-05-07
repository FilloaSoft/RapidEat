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
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<UserAllergy> allergyList;
    @OneToMany(mappedBy = "user")
    private List<UserDiet> dietList;
    @OneToMany(mappedBy = "user")
    private List<UserBarcode> barcodeList;
    @OneToMany(mappedBy = "user")
    private List<UserRecipe> recipeList;

    public User() {
        this.allergyList = new ArrayList<>();
        this.dietList = new ArrayList<>();
        this.barcodeList = new ArrayList<>();
        this.recipeList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserAllergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(List<UserAllergy> allergyList) {
        this.allergyList = allergyList;
    }

    public List<UserDiet> getDietList() {
        return dietList;
    }

    public void setDietList(List<UserDiet> dietList) {
        this.dietList = dietList;
    }

    public List<UserBarcode> getBarcodeList() {
        return barcodeList;
    }

    public void setBarcodeList(List<UserBarcode> barcodeList) {
        this.barcodeList = barcodeList;
    }

    public List<UserRecipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<UserRecipe> recipeList) {
        this.recipeList = recipeList;
    }
}
