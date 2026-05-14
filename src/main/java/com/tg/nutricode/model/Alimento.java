package com.tg.nutricode.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Importado da tabela TACO (Tabela Brasileira de Composiçao de alimentos)
@Entity
@Table(name = "alimentos")
public class Alimento {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    // Os nutrientes, calorias etc na taco sao por 100g*
    @Column(name = "kcal")
    private Double kcal;

    @Column(name = "protein")
    private Double protein;

    @Column(name = "carbohydrates")
    private Double carbohydrates;

    @Column(name = "lipids")
    private Double lipids;

    @Column(name = "dietary_fiber")
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
