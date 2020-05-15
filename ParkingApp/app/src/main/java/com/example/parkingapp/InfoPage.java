package com.example.parkingapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoPage extends AppCompatActivity {

    TextView info_page_PName, info_page_PDesc,info_page_PAdress,info_page_Pmax,info_page_CurrentCap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.click);

        info_page_PName = findViewById(R.id.click_ParkingNaam);
        info_page_PAdress = findViewById(R.id.click_ParkingAdress);
        info_page_PDesc = findViewById(R.id.click_ParkingDesc);
        info_page_Pmax = findViewById(R.id.click_ParkingTotaalCap);
        info_page_CurrentCap = findViewById(R.id.click_ParkingHuidige);


        info_page_CurrentCap.setText(getIntent().getStringExtra("click_parking_huidige"));
        info_page_PName.setText(getIntent().getStringExtra("click_parking_Name"));
        info_page_PDesc.setText(getIntent().getStringExtra("click_parking_desc"));
        //info_page_PDesc.setText("U mama");
        info_page_PAdress.setText(getIntent().getStringExtra("click_parking_Adress"));
//        info_page_PAdress.setText("PAPI");
        info_page_Pmax.setText(getIntent().getStringExtra("click_parking_Total"));




    }






}
