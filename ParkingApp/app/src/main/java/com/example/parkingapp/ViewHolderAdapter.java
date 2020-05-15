package com.example.parkingapp;

import android.content.Context;
import android.content.Intent;
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
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder Adapter, int position) {

        String parkingNaam = parkingList.get(position).getName();
        Log.i("big machine:",parkingList.get(position).getName());
        Log.i("big machine:",String.valueOf(parkingList.get(position).parkingStatus.getAvailableCapacity()));
        Adapter.view_parkingNaam.setText(parkingNaam);
        //String int casten = String.valueOf(u int)
        Adapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                Intent intentManager = new Intent(context, InfoPage.class);


                intentManager.putExtra("click_parking_Name",parkingNaam);
                //todo iets lmao
                intentManager.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intentManager);
            }
        });
    }

    @Override
    public int getItemCount() {
        return parkingList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView view_parkingNaam;
        ItemClickListener itemClickListener;

        ViewHolder(View view) {
            super(view);
            view_parkingNaam = view.findViewById(R.id.ParkingNaam);
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


}
