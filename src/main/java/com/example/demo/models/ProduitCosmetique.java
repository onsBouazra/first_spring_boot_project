package com.example.demo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("ProduitCosmetique")
@Entity
public class ProduitCosmetique extends Produit {

    private String nomProduitCosmetique;

    public String getNomProduitCosmetique() {
        return nomProduitCosmetique;
    }

    public void setNomProduitCosmetique(String nomProduitCosmetique) {
        this.nomProduitCosmetique = nomProduitCosmetique;
    }

    public ProduitCosmetique(String description, double prix, String nomProduitCosmetique) {
        super(description, prix);
        this.nomProduitCosmetique = nomProduitCosmetique;
    }

    public ProduitCosmetique() {
    }
}
