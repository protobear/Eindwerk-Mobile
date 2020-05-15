package com.example.parkingapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoPage extends AppCompatActivity {

    TextView info_page_PName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.click);

        Intent from_Adapater = getIntent();
        info_page_PName = findViewById(R.id.click_ParkingNaam);
        info_page_PName.setText(from_Adapater.getStringExtra("click_parking_Name"));



    }






}
