package com.example.demo.models;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("ProduitAlimentaire")
@Entity
public class ProduitAlimentaire extends Produit {

private String nomProduitAlimentaire;

    public String getNomProduitAlimentaire() {
        return nomProduitAlimentaire;
    }

    public void setNomProduitAlimentaire(String nomProduitAlimentaire) {
        this.nomProduitAlimentaire = nomProduitAlimentaire;
    }

    public ProduitAlimentaire(String description, double prix, String nomProduitAlimentaire) {
        super(description, prix);
        this.nomProduitAlimentaire = nomProduitAlimentaire;
    }

    public ProduitAlimentaire() {
    }
}
