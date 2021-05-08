package com.example.dsapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class AddClientActivity extends AppCompatActivity implements View.OnClickListener {


    private final int CLIENT_LIST_ACTIVITY_RESULT = 4;
    private final ClientList Client = new ClientList();
    private Button dateButton;
    private Button addClientButton;
    private TextView textDate;
    private Date birthDate = new Date();
    DatabaseReference reff;
     Client client;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        Client.addAll((ClientList) getIntent().getParcelableExtra("ClientList"));
        textDate = findViewById(R.id.textdate);
        dateButton = findViewById(R.id.datebutton);
        dateButton.setOnClickListener(this);
        addClientButton = findViewById(R.id.addclientbutton);
        addClientButton.setOnClickListener(this);
        Intent i=getIntent();
        reff= FirebaseDatabase.getInstance().getReference().child(i.getStringExtra("child_name"));
        client=new Client();

    }

    public AddClientActivity(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public void onClick(View v) {
        if (v == dateButton) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            String dateStr = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                            textDate.setText(dateStr);
                            birthDate.setYear(year);
                            birthDate.setMonth(monthOfYear);
                            birthDate.setDate(dayOfMonth);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        } else if (v == addClientButton) {
            EditText inputName = findViewById(R.id.input_name);
            String name = inputName.getText().toString();

            EditText inputFirstName = findViewById(R.id.input_first_name);
            String firstName = inputFirstName.getText().toString();

            EditText inputEmail = findViewById(R.id.input_email);
            String email = inputEmail.getText().toString();

            Client.add(new Client(name, firstName, birthDate));

            Intent intent = new Intent(AddClientActivity.this, ClientList.class);
            intent.putExtra("ClientList", (Parcelable) Client);
            startActivityForResult(intent, CLIENT_LIST_ACTIVITY_RESULT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CLIENT_LIST_ACTIVITY_RESULT) {
            if (resultCode == RESULT_OK && null != data) {
                Client.clear();
                Client.addAll((ClientList) data.getParcelableExtra("ClientList"));
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddClientActivity.this, MainActivity.class);
        intent.putExtra("ClientList", (Parcelable) Client);
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }

}
