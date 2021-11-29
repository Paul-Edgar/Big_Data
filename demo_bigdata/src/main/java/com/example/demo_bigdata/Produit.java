package com.example.demo_bigdata;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// pour la génération des constructeurs, getters et setters, on aurait pu utiliser Lombook
public class Produit {
    @Id
    private int identifiant;
    private String designation;
    private double prix;

    public Produit() {
    }

    public Produit(int identifiant, String designation, double prix) {
        this.identifiant = identifiant;
        this.designation = designation;
        this.prix = prix;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
