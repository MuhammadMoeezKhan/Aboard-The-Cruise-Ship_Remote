package com.muhammadmoeezkhan.remotecruising;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.muhammadmoeezkhan.remotecruising.databinding.ActivityDeletePassengerBinding;

public class DeletePassenger extends AppCompatActivity {

    private ActivityDeletePassengerBinding binding;

    // Listener
    private View.OnClickListener button_delete_passenger_clickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeletePassengerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonDeletePassenger.setOnClickListener(button_delete_passenger_clickListener);
    }
}