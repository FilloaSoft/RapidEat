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
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "recipe")
    private List<StepRecipe> stepList;
    @OneToMany(mappedBy = "recipe")
    private List<IngredientRecipe> ingredientList;

    public Recipe() {
        this.stepList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<StepRecipe> getStepList() {
        return stepList;
    }

    public void setStepList(List<StepRecipe> stepList) {
        this.stepList = stepList;
    }
}
