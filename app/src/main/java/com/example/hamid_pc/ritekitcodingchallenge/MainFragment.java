package com.example.hamid_pc.ritekitcodingchallenge;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainFragment extends Fragment {

    CallbackManager callbackManager;


    private LoginButton mLoginButton;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);

        mLoginButton = (LoginButton) view.findViewById(R.id.login_button);
        mLoginButton.setReadPermissions("email");
        // If using in a fragment
        mLoginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        mLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
    }

}