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


public class InfluenceListFragment extends Fragment {


    private static final String API_KEY = BuildConfig.API_KEY;
    private static final String ARG_HASH = "hash_tag";
    private final String TAG = "InflunencerListActivity";
    private RecyclerView mRecyclerView;
    private InfluencerAdapter mInfluencerAdapter;
    private SOService mInfluencerService;
    private SOService mAuthSOService;
    private String mHashTag;

    public static InfluenceListFragment newInstance(String hashTag) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_HASH, hashTag);
        InfluenceListFragment fragment = new InfluenceListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mHashTag = (String) getArguments().getSerializable(ARG_HASH);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAuthSOService = ApiUtils.getAuthenticate();
        mInfluencerService = ApiUtils.getSOService();

        mInfluencerAdapter = new InfluencerAdapter(getActivity(), new ArrayList<Influencer>(0), new InfluencerAdapter.InfluencerItemListener() {
            @Override
            public void onPostClick(String username) {

            }
        });
        mRecyclerView.setAdapter(mInfluencerAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        loadInfluencers();

        return view;
    }

    public void loadInfluencers() {

        mAuthSOService.getAuthenticate(API_KEY).enqueue(new Callback<TrendingHashResponse>() {
            @Override
            public void onResponse(Call<TrendingHashResponse> call, Response<TrendingHashResponse> response) {
                call.request().url().toString();
            }

            @Override
            public void onFailure(Call<TrendingHashResponse> call, Throwable t) {

            }
        });

        mInfluencerService.getInfluencers(mHashTag).enqueue(new Callback<InfluencerResponse>() {
            @Override
            public void onResponse(Call<InfluencerResponse> call, Response<InfluencerResponse> response) {


                if (response.isSuccessful()) {
                    mInfluencerAdapter.updateHashTag(response.body().getInfluencers());
                    Log.w("2.0 getFeed ", new GsonBuilder().setPrettyPrinting().create().toJson(response));

                } else {
                    int statusCode = response.code();
                    Log.d(TAG, "" + statusCode);

                    Log.d("Check", call.request().url().toString());
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<InfluencerResponse> call, Throwable t) {
//                Log.d("Check", call.request().url().toString());
                Log.d(TAG, "error loading from API" + t.getMessage());

            }
        });
    }
}
