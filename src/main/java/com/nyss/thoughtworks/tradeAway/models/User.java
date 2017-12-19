package com.nyss.thoughtworks.tradeAway.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "user_table")
@XmlRootElement
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column private String name;
    @Column private String emailId;
    @Column private String username;
    @Column private String password;
    @Column private String address;
    @Column private String mobile;
    @Column private Gender gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column private Date dob;

    public User(Long id, String name, String emailId, String username, String password, String address, String mobile, Gender gender, Date dob) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.username = username;
        this.password = password;
        this.address = address;
        this.mobile = mobile;
        this.gender = gender;
        this.dob = dob;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    protected User() {

    }
}
