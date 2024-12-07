package com.vineeth.jwtauthentication.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private String companyName;
    @OneToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    private RoleModel role;

    public UserModel(int id, String username, String email, String password, String companyName, RoleModel role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.role = role;
    }

    public UserModel(String username, String password, String email, String companyName, RoleModel role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.companyName = companyName;
        this.role = role;
    }

    public UserModel(String username, String password, String email, RoleModel role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", role=" + role +
                '}';
    }

}
