package com.example.dsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter {

    Activity context;
    String[] items;

    MyAdapter(Activity c, String[] a) {
        super(c, R.layout.activity_my_adapter, a);
        this.context = c;
        this.items = a;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View element = inflater.inflate(R.layout.activity_my_adapter, null);

        TextView achat = (TextView) element.findViewById(R.id.achat);

        achat.setText(items[position]);
    return  achat;
    }
}