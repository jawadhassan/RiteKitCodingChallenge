package com.example.hamid_pc.ritekitcodingchallenge;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.facebook.CallbackManager;

public class MainActivity extends SingleFragmentActivity {

    CallbackManager callbackManager;

    @Override
    protected Fragment createFragment() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        fragment.onActivityResult(requestCode, resultCode, data);
    }
}
