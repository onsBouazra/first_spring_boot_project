package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "fournisseur")
@Entity

public class Fournisseur extends User{
    private  String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Fournisseur(Long id, String nom, String prenom, String telephone) {
        super(id, nom, prenom);
        this.telephone = telephone;
    }

    public Fournisseur() {

    }
}
