package com.kondo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_building")
public class Building extends CreateAndUpdate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String number;
    private String address2;
    private String zipCode;
    private String state;
    private String city;
    private String province;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<Apartment> apartments;

    @ManyToMany(mappedBy = "buildings")
    private Set<User> users = new HashSet<>();

    public Building() {
    }

    public Building(Instant creationDate, Integer createdBy, Instant lastUpdateDate, Integer lastUpdateBy, Long id, String name, String address, String number, String address2, String zipCode, String state, String city, String province) {
        super(creationDate, createdBy, lastUpdateDate, lastUpdateBy);
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.address2 = address2;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building that = (Building) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

