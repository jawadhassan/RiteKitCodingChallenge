package com.example.hamid_pc.ritekitcodingchallenge;


public class ApiUtils {


    public static final String BASE_URL = "https://api.ritekit.com";

    public static SOService getAuthenticate() {

        return RetrofitClient.getClient(BASE_URL).create(SOService.class);

    }

    public static SOService getSOService() {


        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }


}
