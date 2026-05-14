package com.tg.nutricode.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

/* 
   Baseado na tabela ExerciciosDB traduzido em ptbr.
   Nao é por padrao relacional como a TACO.
   Musculo primario e secundario, instrucoes e imagens vieram como listas ( primaryMuscles[] ),
   entao para colocar no banco relacional teve que ser feito dessa forma (Collections).
 */
@Entity
@Table(name = "exercises") 
public class Exercicio {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "force")
    private String force;

    @Column(name = "level")
    private String level;

    @Column(name = "mechanic")
    private String mechanic;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "category")
    private String category;

    // relacoes para import (é um json com listas)
    
    @ElementCollection // Indica que é uma lista simples (não é outra entidade)
    @CollectionTable(
        name = "exercise_primary_muscles", // Tabela separada
        joinColumns = @JoinColumn(name = "exercise_id") // FK
    )
    @Column(name = "muscle")
    private List<String> primaryMuscles;

    @ElementCollection
    @CollectionTable(
        name = "exercise_secondary_muscles", 
        joinColumns = @JoinColumn(name = "exercise_id")
    )
    @Column(name = "muscle")
    private List<String> secondaryMuscles;

    @ElementCollection
    @CollectionTable(
        name = "exercise_instructions", 
        joinColumns = @JoinColumn(name = "exercise_id")
    )
    @Column(name = "instruction", columnDefinition = "TEXT")
    private List<String> instructions;

    @ElementCollection
    @CollectionTable(
        name = "exercise_images", 
        joinColumns = @JoinColumn(name = "exercise_id")
    )
    @Column(name = "image")
    private List<String> images;

    // // // // // // // // // // // // //
    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForce() {
        return force;
    }

    public void setForce(String force) {
        this.force = force;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getPrimaryMuscles() {
        return primaryMuscles;
    }

    public void setPrimaryMuscles(List<String> primaryMuscles) {
        this.primaryMuscles = primaryMuscles;
    }

    public List<String> getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(List<String> secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
    
}