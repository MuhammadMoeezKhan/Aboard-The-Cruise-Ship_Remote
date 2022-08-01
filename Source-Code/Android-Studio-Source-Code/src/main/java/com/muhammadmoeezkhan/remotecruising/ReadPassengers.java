package com.muhammadmoeezkhan.remotecruising;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.muhammadmoeezkhan.remotecruising.database.Passenger;
import com.muhammadmoeezkhan.remotecruising.database.RetrofitClient;
import com.muhammadmoeezkhan.remotecruising.database.WebInterface;
import com.muhammadmoeezkhan.remotecruising.databinding.ActivityReadPassengersBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadPassengers extends AppCompatActivity {

    private ActivityReadPassengersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReadPassengersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WebInterface myWebInterface = RetrofitClient.getInstance().getWebInterface();       //object that implements all the WebInterface interface

        Call<List<Passenger>> call = myWebInterface.getAllPassengers();                     //list of records in database's table
        call.enqueue(new Callback<List<Passenger>>() {                                      //pass in Callback list and implement two method of the class
            @Override
            public void onResponse(Call<List<Passenger>> call, Response<List<Passenger>> response){     //first method
                if(response.isSuccessful()){
                    List<Passenger> results = response.body();

                    ArrayAdapter<Passenger> adapter = new ArrayAdapter<Passenger>(ReadPassengers.this, android.R.layout.simple_list_item_1, results);
                    binding.listviewPassengers.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Passenger>> call, Throwable t) {                    //second method

            }
        });

    }
}