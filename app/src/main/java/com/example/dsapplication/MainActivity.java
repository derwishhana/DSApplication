package com.example.dsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        AutoCompleteTextView autoSaisie;
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

                ArrayAdapter ar = new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line, this.allClient);

                autoSaisie.setAdapter(ar);

                autoSaisie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                        selectedClient= ((TextView) v).getText().toString();

                        MyAdapter adapter;

                        if (selectedClient.equals("hana")) {
                            adapter = (MyAdapter) new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,AchatHana);


                        } else if (selectedClient.equals("sana")) {
                            adapter = (MyAdapter) new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, Achatsana);

                        } else if(selectedClient.equals("bilel")){
                            adapter = (MyAdapter) new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, AchatBilel);

                        }
                    else {
                            adapter = (MyAdapter) new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, AchatMalek);
                        }


                        lst.setAdapter(adapter);

                        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                                String selectedProduit = allProduit[position];
                                TextView myAchat = (TextView) v;
                                Double achat = Double.parseDouble(myAchat.getText().toString());

                                if (achat >= 10)
                                    Toast.makeText(getApplicationContext(), selectedProduit + " :Congratulations  !! you have a gift", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(getApplicationContext(), selectedProduit + " :Congratulations ", Toast.LENGTH_LONG).show();



                            }
                        });



                    }
                });
            }
        }


