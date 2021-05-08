package com.example.dsapplication;

public class ProduitResponse {
    private int id;
    private int quantite;
    private float prixU;
    private String refProd;
    private int fournisseur;

    public ProduitResponse(int id, int quantite, float prixU, String refProd,int fournisseur) {
        this.id = id;
        this.quantite = quantite;
        this.prixU = prixU;
        this.refProd = refProd;
        this.fournisseur = fournisseur;
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

    public void setFournisseur(int fournisseur) {
        this.fournisseur = fournisseur;
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

    public int getFournisseur() {
        return fournisseur;
    }
}
