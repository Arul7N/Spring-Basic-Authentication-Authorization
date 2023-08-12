package com.example.SecurityApp.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "UserInfo")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String email;

    private String password;

    private String Roles;

    public Info() {
    }

    public Info(Long id, String name, String email, String password, String roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        Roles = roles;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String roles) {
        Roles = roles;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
