package com.muhammadmoeezkhan.remotecruising.database;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebInterface {

    @GET("passenger/")
    Call<List<Passenger>> getAllPassengers();

    @POST("passenger/")
    Call<Integer> insertPassenger(@Body Passenger p);

    @GET("passenger/")
    Call<Passenger> getPassengerById(@Query ("id") int id);

    /*
    @PUT("passenger/")
    Call<Integer> updatePassenger(@Body Passenger p);
    */

    /*
    @DELETE("passenger/")
    Call<Integer> deletePassenger(@Body Passenger p);
    */

}
