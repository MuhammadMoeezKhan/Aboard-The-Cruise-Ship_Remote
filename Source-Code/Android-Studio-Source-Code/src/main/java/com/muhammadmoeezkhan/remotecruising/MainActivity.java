package com.muhammadmoeezkhan.remotecruising;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.muhammadmoeezkhan.remotecruising.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonCreatePassenger.setOnClickListener(this);
        binding.buttonReadPassengers.setOnClickListener(this);
        binding.buttonUpdatePassenger.setOnClickListener(this);
        binding.buttonDeletePassenger.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_create_passenger:{
                Intent myIntent = new Intent(this, CreatePassenger.class);
                startActivity(myIntent);
                break;
            }
            case R.id.button_read_passengers:{
                Intent myIntent = new Intent(this, ReadPassengers.class);
                startActivity(myIntent);
                break;
            }
            case R.id.button_update_passenger:{
                Intent myIntent = new Intent(this, UpdatePassenger.class);
                startActivity(myIntent);
                break;
            }
            case R.id.button_delete_passenger:{
                Intent myIntent = new Intent(this, DeletePassenger.class);
                startActivity(myIntent);
                break;
            }
        }
    }
}