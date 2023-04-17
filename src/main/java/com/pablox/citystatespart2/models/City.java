package com.pablox.citystatespart2.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cities")
public class City {
    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // City Name
    @NotBlank(message = "City name is required")
    @Size(min = 1, max = 12, message = "Name must be between 3 and 12 characters")
    private String cityName;

    // REL
        @ManyToOne(fetch = FetchType.LAZY)
    // foreign key
        @JoinColumn(name="state_id")
    //
        private State state;

        @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Organization> organizations;

        @OneToMany(mappedBy = "residence", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Person> citizens;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // constructor
    public City() {
    }

    // method overloading
    public City(
            String cityName

    ) {
        this.cityName = cityName;


    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Person> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Person> citizens) {
        this.citizens = citizens;
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
