package com.tg.nutricode.model;

import java.time.Instant;
import jakarta.persistence.*;

/* Entidade somente para tokens do usuario. Inicialmente
era colocado tudo no usuario, mas decidi q era melhor separar */

@Entity
@Table(name = "user_tokens")
public class UserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Column(name = "password_reset_token")
    private String passwordResetToken;

    @Column(name = "password_reset_expiry")
    private Instant passwordResetExpiry;

    // // // // // // // // // // // // // // / // // // //
    // Getters e Setters

    public UserToken() {}

    public UserToken(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public Instant getPasswordResetExpiry() {
        return passwordResetExpiry;
    }

    public void setPasswordResetExpiry(Instant passwordResetExpiry) {
        this.passwordResetExpiry = passwordResetExpiry;
    }
}