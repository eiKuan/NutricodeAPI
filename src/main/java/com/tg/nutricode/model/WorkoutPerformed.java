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
@Table(name = "Workout_Performed")
@IdClass(WorkoutPerformedId.class)
public class WorkoutPerformed {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "isFinished", nullable = false)
    private boolean isFinished;

    // // // // // // // // // // // // // // / // // // //
    // Getters e Setters

    public WorkoutPerformed(){

    }

    public WorkoutPerformed(User user, LocalDate date, boolean isFinished) {
        this.user = user;
        this.date = date;
        this.isFinished = isFinished;
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

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    
}
