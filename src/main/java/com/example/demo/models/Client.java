package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "client")
@Entity
public class Client  extends User{

    private String adress;


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Client(Long id, String nom, String prenom, String adress) {
        super(id, nom, prenom);
        this.adress = adress;
    }

    public Client(){

    }
}
