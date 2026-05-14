package com.tg.nutricode.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

// Classe para fazer uma chave composta em Spring e n precisar de id unico

public class DietPerformedId implements Serializable {

    private String user;
    private LocalDate date;

    // // // // // // // // // // // // // // / // // // //
    // Getters e Setters

    public DietPerformedId() {
    }

    public DietPerformedId(String user, LocalDate date) {
        this.user = user;
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //Logica de implementaçao e tesde de objeto id

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof DietPerformedId))
            return false;
        DietPerformedId that = (DietPerformedId) o;
        return Objects.equals(user, that.user) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, date);
    }
}