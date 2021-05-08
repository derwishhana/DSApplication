package com.example.dsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.LinkedList;

public class ClientAdapter extends ArrayAdapter<Client> {

        private final Context context;
        private LinkedList<Client> clients;

    ClientAdapter(Context context, int resource, LinkedList<Client> clients) {
            super(context, resource, clients);
            this.context = context;
            this.clients = clients;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_item, parent, false);
            }
            ImageView imageView = convertView.findViewById(R.id.picture);

            TextView fullNameView = convertView.findViewById(R.id.name);
            String fullName = clients.get(position).getFirstName() + " " + clients.get(position).getName();
            fullNameView.setText(fullName);
            return convertView;
        }

    }


