package com.muhammadmoeezkhan.remotecruising;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.muhammadmoeezkhan.remotecruising.database.Passenger;
import com.muhammadmoeezkhan.remotecruising.database.RetrofitClient;
import com.muhammadmoeezkhan.remotecruising.database.WebInterface;
import com.muhammadmoeezkhan.remotecruising.databinding.ActivityCreatePassengerBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePassenger extends AppCompatActivity {

    private ActivityCreatePassengerBinding binding;

    // Listener
    private View.OnClickListener button_create_passenger_clickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            String firstName = binding.edittextFirstName.getText().toString();
            String lastName = binding.edittextLastName.getText().toString();
            int passport = Integer.valueOf(binding.edittextPassport.getText().toString());
            String birthdate = binding.edittextBirthdate.getText().toString();
            String city = binding.edittextCity.getText().toString();
            String state = binding.edittextState.getText().toString();

            Passenger myPassenger = new Passenger(firstName, lastName, passport, birthdate, city, state);

            WebInterface myWebInterface = RetrofitClient.getInstance().getWebInterface();

            Call<Integer> call = myWebInterface.insertPassenger(myPassenger);
            call.enqueue(new Callback<Integer>() {

                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    if(response.isSuccessful()){
                        int id = response.body();
                        Toast.makeText(CreatePassenger.this, "Passenger with id: " + String.valueOf(id) + " has been inserted!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) { /*No Implementation*/ }

            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreatePassengerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCreatePassenger.setOnClickListener(button_create_passenger_clickListener);
    }
}