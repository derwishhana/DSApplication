package com.example.dsapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.LinkedList;


public class ProduitAdapter  extends ArrayAdapter {

    Activity context;
    private LinkedList<Produit> produits;


    public ProduitAdapter(Activity context, LinkedList<Produit> produits) {
        super(context, R.layout.activity_produit, produits);
        this.context = context;
        this.produits = produits;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            View element = inflater.inflate(R.layout.activity_produit, null);
            ImageView imageView = convertView.findViewById(R.id.picture);
            TextView infoView = convertView.findViewById(R.id.name);
            String fullProd = produits.get(position).getId() + " " + produits.get(position).getQuantite() + "" + produits.get(position).getPrixU() + "" + produits.get(position).getReference();
            infoView.setText(fullProd);

        }
        return convertView;

    }
}