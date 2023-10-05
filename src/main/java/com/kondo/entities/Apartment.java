package com.kondo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_apartment")
public class Apartment extends CreateAndUpdate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apartment;
    private String tower;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Apartment() {
    }

    public Apartment(Instant creationDate, Integer createdBy, Instant lastUpdateDate, Integer lastUpdateBy, Long id, String apartment, String tower, Building building) {
        super(creationDate, createdBy, lastUpdateDate, lastUpdateBy);
        this.id = id;
        this.apartment = apartment;
        this.tower = tower;
        this.building = building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public Building getBuilding() {
        return building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return Objects.equals(id, apartment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
