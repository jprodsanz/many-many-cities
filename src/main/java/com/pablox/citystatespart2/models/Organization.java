package com.pablox.citystatespart2.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="organizations")
public class Organization {
    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Org Name
    @NotBlank(message = "Org name is required")
    @Size(min = 1, max = 12, message = "Org name must be between 3 and 12 characters")
    private String orgName;

    // REL
        @ManyToOne(fetch = FetchType.LAZY)
    // foreign key
        @JoinColumn(name="city_id")
    //
        private City city;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "person_in_org",
            joinColumns = @JoinColumn(name="organization_id"),
            inverseJoinColumns = @JoinColumn(name="person_id")
    )
    private List<Person> orgMembers;


    // This will not allow the createdAt column to be updated after creation
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // constructor
    public Organization() {
    }

    // method overloading
    public Organization(
            String orgName

    ) {
        this.orgName = orgName;


    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Person> getOrgMembers() {
        return orgMembers;
    }

    public void setOrgMembers(List<Person> orgMembers) {
        this.orgMembers = orgMembers;
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
