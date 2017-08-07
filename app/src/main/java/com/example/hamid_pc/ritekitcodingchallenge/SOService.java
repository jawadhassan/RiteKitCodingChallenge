package com.example.hamid_pc.ritekitcodingchallenge;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {


    @GET("/v1/search/trending")
    Call<TrendingHashResponse> getTrends(
            @Query("green") int one,
            @Query("latin") int two);


    @GET("/v1/stats/basic/php")
    Call<TrendingHashResponse> getAuthenticate(
            @Query("client_id") String API_KEY);


}
