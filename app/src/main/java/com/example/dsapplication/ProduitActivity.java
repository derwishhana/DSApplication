package com.example.dsapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ProduitActivity extends AppCompatActivity {
    private EditText id;
    private EditText prix;
    private EditText refProd;
    private EditText quantite;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);
        id = findViewById(R.id.id);
        prix = findViewById(R.id.prix);
        refProd = findViewById(R.id.refProd);
        quantite = findViewById(R.id.quantite);
        img = findViewById(R.id.imageView);
        Button edit =findViewById(R.id.edit);
        Button goback=findViewById(R.id.goback);
        Button delete=findViewById(R.id.delete);
        Bundle bundle=getIntent().getExtras();

        if(bundle!=null){
            img.setImageResource(R.drawable.prod);
            id.setText(bundle.getString("id"));
            refProd.setText(bundle.getString("refProd"));
            quantite.setText(bundle.getString("quantite"));
            prix.setText(bundle.getString("prix"));
    }
        edit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updatepoduit();
            }
            private void updatepoduit()
            {
                final String idP=id.getText().toString().trim();
                final String refP=refProd.getText().toString().trim();
                final String quantiteP=quantite.getText().toString().trim();
                final String prixP=prix.getText().toString().trim();

                if(refP.isEmpty())
                {
                    refProd.setError("Reference is required");
                    refProd.requestFocus();
                    return;
                }
                if(refP.isEmpty())
                {
                    refProd.setError("Reference is required");
                    refProd.requestFocus();
                    return;
                }
                if(quantiteP.isEmpty())
                {
                    quantite.setError("Qunatite is required");
                    quantite.requestFocus();
                    return;
                }
                if(prixP.isEmpty())
                {
                    prix.setError("Prix is required");
                    prix.requestFocus();
                    return;
                }

            }
        });
            delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder( ProduitActivity.this );
                builder.setTitle("Are you sure ?");
                builder.setMessage("This action is irreversible !");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       return;
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();
            }});

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProduitActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });}}


