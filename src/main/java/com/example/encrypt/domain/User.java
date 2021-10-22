package com.example.encrypt.domain;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Table(name = "kei_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "region", columnDefinition = "bytea")
    @ColumnTransformer(read = "pgp_sym_decrypt(region, 'mySecretKey')", write = "pgp_sym_encrypt(?, 'mySecretKey')")
    private String region;

    @Column(name = "phone_number", columnDefinition = "bytea")
    @ColumnTransformer(read = "pgp_sym_decrypt(phone_number, 'mySecretKey')", write = "pgp_sym_encrypt(?, 'mySecretKey')")
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
