package com.example.chatproject.Fragments;

import com.example.chatproject.Notifications.MyResponse;
import com.example.chatproject.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AIzaSyClHmynBfAWpHgiMoCuUdSQCUOu0vTMWiA"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
