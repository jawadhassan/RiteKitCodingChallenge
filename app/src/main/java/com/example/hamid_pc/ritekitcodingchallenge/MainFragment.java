package com.example.hamid_pc.ritekitcodingchallenge;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainFragment extends Fragment {


    private static Retrofit mRetrofit;
    private final String TAG = getClass().getSimpleName();
    String API_KEY = "9fc671f51275e0363e866bcc7ab93fa25ce010afe693";
    private RecyclerView mRecyclerView;
    private HashTagAdapter mHashTagAdapter;
    private SOService mSOService;


    //Assign Api Key
    private SOService mAutSOService;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mAutSOService = ApiUtils.getAuthenticate();
        mSOService = ApiUtils.getSOService();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHashTagAdapter = new HashTagAdapter(getActivity(), new ArrayList<Tag>(0), new HashTagAdapter.TagItemListener() {
            @Override
            public void onPostClick(long id) {
                Log.d("check", "check");
            }
        });

        mRecyclerView.setAdapter(mHashTagAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);


        loadAnswers();
        return view;
    }

    public void loadAnswers() {

        mAutSOService.getAuthenticate(API_KEY);

        mSOService.getTrends(1, 1).enqueue(new Callback<TrendingHashResponse>() {
            @Override
            public void onResponse(Call<TrendingHashResponse> call, Response<TrendingHashResponse> response) {


                Log.d("Check", call.request().url().toString());
                if (response.isSuccessful()) {
                    mHashTagAdapter.updateHashTag(response.body().getTags());
                    Log.w("2.0 getFeed ", new GsonBuilder().setPrettyPrinting().create().toJson(response));
                    Log.d("MainActivity", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Log.d("Check", "" + statusCode);


                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<TrendingHashResponse> call, Throwable t) {
                Log.d("Check", call.request().url().toString());
                Log.d("MainActivity", "error loading from API" + t.getMessage());

            }
        });
    }

}