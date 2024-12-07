package com.vineeth.jwtauthentication.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "rolename",unique = true)
    private String rolename;

    public RoleModel(int id) {
        this.id = id;
    }

    public RoleModel(String rolename) {
        this.rolename = rolename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public RoleModel(int id, String rolename) {
        this.id = id;
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
