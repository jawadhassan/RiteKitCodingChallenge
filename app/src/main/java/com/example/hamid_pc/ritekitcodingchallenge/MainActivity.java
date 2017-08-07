package com.example.hamid_pc.ritekitcodingchallenge;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        return starter;
    }

    @Override
    protected Fragment createFragment() {
        return MainFragment.newInstance();
    }


}
