package com.pablox.citystatespart2.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Username is required")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String username;

    @NotBlank (message = "Email is required")
    @Email(message="Please enter a valid email!")
    private String email;

    @NotBlank (message="Your password is required")
    @Size(min=8, message="Password must be at least eight characters")
    private String password;

    @Transient // will not store it in DB
    @NotBlank(message="Your password is required")
    private String confirmPass;

    @Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    @OneToMany(mappedBy = "submittedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<State> statesSubmitted;

    // constructor
    public User() {}

    // method overloading but wait... What does this do again ?
    public User (
            String username,
            String email
    ) {
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public List<State> getStatesSubmitted() {
        return statesSubmitted;
    }

    public void setStatesSubmitted(List<State> statesSubmitted) {
        this.statesSubmitted = statesSubmitted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    @PrePersist
    // is this protected or public
    protected void onCreate(){
        this.createdAt = new Date();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    // is this protected or public
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
