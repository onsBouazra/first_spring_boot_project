package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)



public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    private Long id;
    private String nom;
    private String prenom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public User(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public User() {
    }
}
