package com.example.dsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Produit extends AppCompatActivity {
    private int id;
    private int quantite;
    private float prixU;
    private String refProd;
    public Produit(int id, int quantite, float prixU, String refProd) {
        this.id = id;
        this.quantite = quantite;
        this.prixU = prixU;
        this.refProd = refProd;

    }

    public float getPrixU() {
        return prixU;
    }

    public void setPrixU(float prixU) {
        this.prixU = prixU;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setReference(String reference) {
        this.refProd = reference;
    }


    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getReference() {
        return refProd;
    }

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);


    }
}