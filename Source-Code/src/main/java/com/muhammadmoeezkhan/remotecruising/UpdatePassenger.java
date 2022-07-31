package com.muhammadmoeezkhan.remotecruising;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.muhammadmoeezkhan.remotecruising.database.Passenger;
import com.muhammadmoeezkhan.remotecruising.database.RetrofitClient;
import com.muhammadmoeezkhan.remotecruising.database.WebInterface;
import com.muhammadmoeezkhan.remotecruising.databinding.ActivityUpdatePassengerBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdatePassenger extends AppCompatActivity {

    private ActivityUpdatePassengerBinding binding;

    // Listeners
    private View.OnClickListener button_find_passenger_clickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            int id  = Integer.valueOf(binding.edittextId.getText().toString());

            WebInterface webInterface = RetrofitClient.getInstance().getWebInterface();

            Call<Passenger> call = webInterface.getPassengerById(id);
            call.enqueue(new Callback<Passenger>(){

                @Override
                public void onResponse(Call<Passenger> call, Response<Passenger> response) {

                    if(response.isSuccessful()){
                        Passenger queryPassenger = response.body();

                        Log.d("CSC","" + queryPassenger.getFirstName() );

                        binding.edittextFirstName.setText(queryPassenger.getFirstName());
                        binding.edittextLastName.setText(queryPassenger.getLastName());
                        binding.edittextPassport.setText(queryPassenger.getPassportNumber());
                        binding.edittextBirthdate.setText(queryPassenger.getBirthDate());
                        binding.edittextCity.setText(queryPassenger.getCity());
                        binding.edittextState.setText(queryPassenger.getState());

                    }
                }

                @Override
                public void onFailure(Call<Passenger> call, Throwable t) {
                }

            })  ;
        }
    };

    private View.OnClickListener button_update_passenger_clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {

            //No Update Implementation

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdatePassengerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonFindPassenger.setOnClickListener(button_find_passenger_clickListener);
        //binding.buttonUpdatePassenger.setOnClickListener(button_find_passenger_clickListener);
    }
}