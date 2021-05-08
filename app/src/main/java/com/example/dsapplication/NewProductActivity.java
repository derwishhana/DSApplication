package com.example.dsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NewProductActivity extends AppCompatActivity {
    private EditText Reference;
    private EditText quantite;
    private EditText prix;
    ImageView img ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
        img = findViewById(R.id.imageViewadd);
        img.setImageResource(R.drawable.prod);
        Button goback = findViewById(R.id.goback);
        Button add = findViewById(R.id.add);
        Reference = findViewById(R.id.Referenceadd);
        quantite = findViewById(R.id.quantiteadd);
        prix = findViewById(R.id.prixadd);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)
        {
                Intent intent = new Intent(NewProductActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

       add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Ref = Reference.getText().toString().trim();
                final String qua = quantite.getText().toString().trim();
                final String pri = prix.getText().toString().trim();

                if (Ref.isEmpty()) {
                    Reference.setError("Reference is required");
                    Reference.requestFocus();
                    return;
                }


                if (qua.isEmpty()) {
                    quantite.setError("quantite required");
                    quantite.requestFocus();
                    return;
                }

                if (pri.isEmpty()) {
                    prix.setError("prix required");
                    prix.requestFocus();
                    return;
                }


            }
        });
    }
}
