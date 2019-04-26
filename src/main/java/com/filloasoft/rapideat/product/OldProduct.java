package com.filloasoft.rapideat.product;

import java.io.Serializable;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OldProduct {

    @Id
    private String id;

    private String product_name;
    private String generic_name;
    private String brands;
    private String traces;
    private String serving_size;
    //0->SIN PALMA 1->CON PALMA
    private String ingredients_from_palm_oil;
    private String image_url;
    private String energy;
    private String proteins;
    private String carbohydrates;
    private String sugars;
    private String fat;
    private String quantity;
    private String manufacturing_places;
    private String stores;
    //https://world.openfoodfacts.org/nutriscore
    private String nutritionScore;
    @ElementCollection
    private List<String> labels_tags;
    @ElementCollection
    private List<String> categories_hierarchy;
    @ElementCollection
    private List<String> Allergens;
    @ElementCollection
    private List<String> ingredients_text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public List<String> getIngredients_text() {
        return ingredients_text;
    }

    public void setIngredients_text(List<String> ingredients_text) {
        this.ingredients_text = ingredients_text;
    }

    public String getTraces() {
        return traces;
    }

    public void setTraces(String traces) {
        this.traces = traces;
    }

    public String getServing_size() {
        return serving_size;
    }

    public void setServing_size(String serving_size) {
        this.serving_size = serving_size;
    }

    public String getIngredients_from_palm_oil() {
        return ingredients_from_palm_oil;
    }

    public void setIngredients_from_palm_oil(String ingredients_from_palm_oil) {
        this.ingredients_from_palm_oil = ingredients_from_palm_oil;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(String carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getSugars() {
        return sugars;
    }

    public void setSugars(String sugars) {
        this.sugars = sugars;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getManufacturing_places() {
        return manufacturing_places;
    }

    public void setManufacturing_places(String manufacturing_places) {
        this.manufacturing_places = manufacturing_places;
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores;
    }

    public List<String> getLabel_tags() {
        return labels_tags;
    }

    public void setLabel_tags(List<String> label_tags) {
        this.labels_tags = label_tags;
    }

    public List<String> getCategories_hierarchy() {
        return categories_hierarchy;
    }

    public void setCategories_hierarchy(List<String> categories_hierarchy) {
        this.categories_hierarchy = categories_hierarchy;
    }

    public List<String> getAllergens() {
        return Allergens;
    }

    public void setAllergens(List<String> allergens) {
        Allergens = allergens;
    }

    public String getNutritionScore() {
        return nutritionScore;
    }

    public void setNutritionScore(String nutritionScore) {
        this.nutritionScore = nutritionScore;
    }

    public List<String> getLabels_tags() {
        return labels_tags;
    }

    public void setLabels_tags(List<String> labels_tags) {
        this.labels_tags = labels_tags;
    }
}
