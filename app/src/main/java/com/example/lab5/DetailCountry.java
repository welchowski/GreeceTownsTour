package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailCountry extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailcountry);
        getSupportActionBar().hide();
        TextView textView = findViewById(R.id.textView3);
        TextView textViewDes = findViewById(R.id.desription);
        ImageView imageView = findViewById(R.id.imageView3);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("name"));
        textViewDes.setText(intent.getStringExtra("description"));
        imageView.setImageResource(Integer.parseInt(intent.getStringExtra("img")));
    }
}

