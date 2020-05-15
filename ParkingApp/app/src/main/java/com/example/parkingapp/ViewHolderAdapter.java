package com.example.parkingapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Callback;

public class ViewHolderAdapter extends RecyclerView.Adapter<ViewHolderAdapter.ViewHolder>{

    List<Parking> parkingList;
    Context context;

    public ViewHolderAdapter(List<Parking> parkingList, Context context) {
        this.parkingList = parkingList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return parkingList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView view_parkingNaam;
        public TextView view_BeschikbarePlaatsen;

        ItemClickListener itemClickListener;


        ViewHolder(View view) {
            super(view);
            view_parkingNaam = view.findViewById(R.id.ParkingNaam);
            view_BeschikbarePlaatsen = view.findViewById(R.id.BeschikbarePlaatsen);

            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v){
            this.itemClickListener.onItemClickListener(v,getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener ic){

            this.itemClickListener = ic;
        }
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder ( ViewHolder Adapter, int position) {

        String parkingNaam = parkingList.get(position).getName();
        String beschikbarePlaatsen = String.valueOf(parkingList.get(position).parkingStatus.getAvailableCapacity());
        Parking curentParking = parkingList.get(position);

        double totalCapacity = parkingList.get(position).parkingStatus.getTotalCapacity();
        double availableCapacity = parkingList.get(position).parkingStatus.getAvailableCapacity();
        double percentageAvailable = (availableCapacity / totalCapacity) * 100;
        //Log.i("DOES THIS THING WORK:",String.valueOf(percentageAvailable));
        double limitForRed= 5.00;
        double limitForOrange = 25.00;
        int color = 0;
        if(percentageAvailable > limitForOrange){
            color = 0xFF2ED573;
            Adapter.view_BeschikbarePlaatsen.setBackgroundColor(color);

        }
        else if(percentageAvailable > limitForRed){
           color = 0xFFFF6348 ;
            Adapter.view_BeschikbarePlaatsen.setBackgroundColor(color);

        }else{
           color = 0xFFFF4D4D;
            Adapter.view_BeschikbarePlaatsen.setBackgroundColor(color);
        }

        Adapter.view_parkingNaam.setText(parkingNaam);
        Adapter.view_BeschikbarePlaatsen.setText(beschikbarePlaatsen);

        //todo: idk check this again it seems pretty fucky wucky
        int finalColor = color;
        Adapter.setItemClickListener((v, position1) -> {
            Intent intentManager = new Intent(context, InfoPage.class);
            //click_parking_huidige
            intentManager.putExtra("color",finalColor);
            intentManager.putExtra("click_parking_huidige",beschikbarePlaatsen);
            intentManager.putExtra("click_parking_desc",curentParking.getDescription());
            intentManager.putExtra("click_parking_Total",String.valueOf(totalCapacity));
            intentManager.putExtra("click_parking_Adress",curentParking.getAddress());
            intentManager.putExtra("click_parking_Name",curentParking.getName());
            intentManager.putExtra("click_parking_contact",curentParking.getContactInfo());
            //todo iets lmao
            intentManager.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentManager);
        });
    }



}
