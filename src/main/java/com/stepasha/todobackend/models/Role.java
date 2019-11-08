package com.stepasha.todobackend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long roleid;
    @Column(nullable = false)
    private String rolename;

    @ManyToMany
    @JoinTable(name = "users",
    joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "todos"))
    List<User> user = new ArrayList<>();

    public Role(){}
    public Role(String rolename) {
        this.rolename = rolename;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}