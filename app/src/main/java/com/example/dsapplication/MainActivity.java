package com.example.dsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.b1 = findViewById(R.id.btn1);
        this.b2 = findViewById(R.id.btn2);
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ClientDetailsActivity.class);
                startActivity(i);
            }
        });


    Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, NewProductActivity.class);
            startActivity(intent);
        }
        });
    }
}








    /*ListView list;
    private List<Produit> produitList;


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this,ProduitActivity.class);
        intent.putExtra("id",Integer.toString(produitList.get(position).getId()));
        intent.putExtra("prix",Float.toString(produitList.get(position).getPrixU()));
        intent.putExtra("Reference",produitList.get(position).getReference());
        intent.putExtra("quantite",Integer.toString(produitList.get(position).getQuantite()));
        startActivity(intent);
        }
        });

        Button btnadd = findViewById(R.id.buttonAdd);
        btnadd.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,NewProductActivity.class);
        startActivity(intent);
        }
        });
        }
        }





















     /*   AutoCompleteTextView autoSaisie;
        ListView lst;
        String[] allClient={"hana","sana","bilel","malek"};
        String[] allProduit={"cosmetique","beaute","soins","solaire","naturel","vestimentaire"};
        String selectedClient;

    String[] AchatHana = {"watch", "fond de teinte", "rouge a levre", "ecran solaire"};
    String[] Achatsana = {"watch", "fond de teinte", "rouge a levre", "ecran solaire"};
    String[] AchatBilel = {"watch", "tendeuse", "gel", "chaussure", "bague"};
    String[] AchatMalek ={"watch", "tendeuse", "gel", "chaussure", "bague"};


        @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                this.lst = this.findViewById(R.id.AchatLst);

                this.autoSaisie = findViewById(R.id.saisieAuto);



            }
        }
*/

