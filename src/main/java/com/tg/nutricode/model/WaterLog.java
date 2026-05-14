package com.tg.nutricode.model;

import java.time.LocalDate;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "water_log")
@IdClass(WaterLogId.class)
public class WaterLog {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "milliliters", nullable = false)
    private int milliliters;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted = false;

    // // // // // // // // // // // // // // / // // // //
    // Getters e Setters
    
    public WaterLog() {
    }

    public WaterLog(User user, LocalDate date, int milliliters) {
        this.user = user;
        this.date = date;
        this.milliliters = milliliters;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(int milliliters) {
        this.milliliters = milliliters;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

}