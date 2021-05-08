package com.example.dsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ClientDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_details);

        Client client = getIntent().getParcelableExtra("Client");
        if (client != null) {
            TextView clientName = findViewById(R.id.client_name);
            clientName.setText(client.getName());
            TextView ClientFirstName = findViewById(R.id.client_first_name);
            ClientFirstName.setText(client.getFirstName());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
            TextView clientBirthDate = findViewById(R.id.button_birthdate);
            clientBirthDate.setText(formatter.format(client.getBirthDate()));
        }}
}
