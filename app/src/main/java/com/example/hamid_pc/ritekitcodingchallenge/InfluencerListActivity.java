package com.example.hamid_pc.ritekitcodingchallenge;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class InfluencerListActivity extends SingleFragmentActivity {


    public static final String EXTRA_HASH_TAG =
            "com.example.hamid_pc.ritekitcodingchallenge.hash.tag";

    public static Intent start(Context context, String hashTag) {
        Intent starter = new Intent(context, InfluencerListActivity.class);
        starter.putExtra(EXTRA_HASH_TAG, hashTag);
        return starter;
    }

    @Override
    protected Fragment createFragment() {
        String hashTag = (String) getIntent().getSerializableExtra(EXTRA_HASH_TAG);

        return InfluenceListFragment.newInstance(hashTag);
    }
}
