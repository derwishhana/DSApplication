package com.example.dsapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ClientListActivity extends AppCompatActivity {

    private final int CLIENT_DETAILS_RESULT = 3;

    private final ClientList clients = new ClientList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        clients.addAll((ClientList) getIntent().getParcelableExtra("ClientList"));

        ClientAdapter adapter = new ClientAdapter(getApplicationContext(), R.layout.activity_client_list, clients);
        ListView clientListView = findViewById(R.id.client_list);
        clientListView.setAdapter(adapter);
        clientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(ClientListActivity.this, ClientDetailsActivity.class);
                intent.putExtra("Client", clients.get(position));
                startActivityForResult(intent, CLIENT_DETAILS_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ClientListActivity.this, MainActivity.class);
        intent.putExtra("ClientList", (Parcelable) clients);
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }

}

