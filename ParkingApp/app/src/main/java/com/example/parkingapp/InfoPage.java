package com.example.parkingapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class InfoPage extends AppCompatActivity {

    TextView info_page_PName, info_page_PDesc,info_page_PAdress,info_page_Pmax,info_page_CurrentCap,info_page_Pcontact,banner_Cap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.click);

        info_page_PName = findViewById(R.id.click_ParkingNaam);
        info_page_PAdress = findViewById(R.id.click_ParkingAdress);
        info_page_PDesc = findViewById(R.id.click_ParkingDesc);
        info_page_Pmax = findViewById(R.id.click_ParkingTotaalCap);
        info_page_Pcontact = findViewById(R.id.click_ParkingContactInformatie);
        banner_Cap = findViewById(R.id.click_ParkingHuidige);


        banner_Cap.setBackgroundColor(getIntent().getIntExtra("color",0));
        banner_Cap.setText(getIntent().getStringExtra("click_parking_huidige"));
        info_page_PName.setText(getIntent().getStringExtra("click_parking_Name"));
        info_page_PDesc.setText(getIntent().getStringExtra("click_parking_desc"));
        info_page_PAdress.setText(getIntent().getStringExtra("click_parking_Adress"));
        info_page_Pcontact.setText(getIntent().getStringExtra("click_parking_contact"));
        info_page_Pmax.setText(getIntent().getStringExtra("click_parking_Total"));

    }


    public void maps(View v){

        String adr = ((TextView)v).getText().toString();
        String uri = String.format(Locale.ENGLISH, "geo:0,0?q="+adr);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);


    }





}
