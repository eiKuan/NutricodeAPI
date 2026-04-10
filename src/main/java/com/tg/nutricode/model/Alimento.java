package com.tg.nutricode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Importado da tabela TACO (Tabela Brasileira de Composiçao de alimentos)
@Entity
@Table(name = "alimentos")
public class Alimento {

    @Id
    private Integer id;

    private String name;

    // Os nutrientes, calorias etc na taco sao por 100g*
    private Double kcal;
    private Double protein;
    private Double carbohydrates;
    private Double lipids;
    private Double dietaryFiber;

    // // // // // // // // // // // // //
    // Getters e Setters

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

    public Double getKcal() {
        return kcal;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getLipids() {
        return lipids;
    }

    public void setLipids(Double lipids) {
        this.lipids = lipids;
    }

    public Double getDietaryFiber() {
        return dietaryFiber;
    }

    public void setDietaryFiber(Double dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

}
