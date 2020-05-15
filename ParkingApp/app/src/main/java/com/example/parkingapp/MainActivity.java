package com.example.parkingapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public boolean hervatten = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getParking();
    }

    @Override
    protected void onResume(){
        super.onResume();

        if(hervatten){
            getParking();
            Toast. makeText(getApplicationContext(),"List info updated",Toast.LENGTH_SHORT).show();
        }
        hervatten =true;
    }


    static final String BASE_URL = "https://datatank.stad.gent/4/";
    public void getParking(){
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ParkingApi parkingApi = retrofit.create(ParkingApi.class);
        Call<List<Parking>> call = parkingApi.getParking();
        call.enqueue(new Callback<List<Parking>>() {
            @Override
            public void onResponse(Call<List<Parking>> call, Response<List<Parking>> response) {
                List<Parking> ParkingList = response.body();

                Log.i("main_machine:",ParkingList.get(1).getName());
                Log.i("main_machine:",String.valueOf(ParkingList.get(1).parkingStatus.getAvailableCapacity()));
                Log.i("main_machine:","sending to adapter");
                RecyclerView recyclerView ;
                RecyclerView.LayoutManager layoutManager;
                recyclerView = findViewById(R.id.recycler_view);
                recyclerView.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                ViewHolderAdapter viewHolderAdapter = new ViewHolderAdapter(ParkingList,  getApplicationContext());
                recyclerView.setAdapter(viewHolderAdapter);
            }

            @Override
            public void onFailure(Call<List<Parking>> call, Throwable t) {
                Log.i("Stack trace error", String.valueOf(t));

            }
        });


    }

}
