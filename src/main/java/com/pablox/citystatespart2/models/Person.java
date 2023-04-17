package com.pablox.citystatespart2.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="persons")
public class Person {
    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // City Name
    @NotBlank(message = "First name is required")
    @Size(min = 1, max = 12, message = "Name must be between 3 and 12 characters")
    private String firstName;

    @NotNull(message = "Enter your age...")
    private int age;

    // REL
        @ManyToOne(fetch = FetchType.LAZY)
    // foreign key
        @JoinColumn(name="city_id")
    //
        private City residence ;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name = "person_in_org",
                joinColumns = @JoinColumn(name="person_id"),
                inverseJoinColumns = @JoinColumn(name="organization_id")
        )
        private List<Organization> organizations;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // constructor
    public Person() {
    }

    // method overloading
    public Person(
            String firstName,
            int age

    ) {
        this.firstName = firstName;
        this.age = age;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public City getResidence() {
        return residence;
    }

    public void setResidence(City residence) {
        this.residence = residence;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    @PrePersist
    private void onCreate(){
        this.createdAt = new Date();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    private void onUpdate(){
        this.updatedAt = new Date();
    }
}
