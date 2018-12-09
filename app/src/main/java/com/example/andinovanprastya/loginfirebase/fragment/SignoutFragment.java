package com.example.andinovanprastya.loginfirebase.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andinovanprastya.loginfirebase.R;
import com.example.andinovanprastya.loginfirebase.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignoutFragment extends Fragment {

    // firebase auth
    private FirebaseAuth.AuthStateListener mAuth;

    // button
    private Button mButton;

    private static final String TAG = "EmailPassword";


    public SignoutFragment() {
        // Required empty public constructor
    }

    // panggil function signout
    public static SignoutFragment newInstance(String param1, String param2) {
        SignoutFragment fragment = new SignoutFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // setting dan menampilkan toast ketika logout dan meneruskan ke halaman loginactivity(halaman yg dituju)
    private void setupFirebaseListener(){
        Log.d(TAG, "setupFirebaseListener: settong up the auth state listener");
        mAuth = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.d(TAG,"auth sign in: "+user.getUid() );
                }else {
                    Log.d(TAG,"auth sign out" );
                    Toast.makeText(getActivity(),"sign out" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuth);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mAuth != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuth);
        }
    }

    // ketika menekan button logout dan tampil
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_signout, container, false);
        mButton = view.findViewById(R.id.signOutButton2);

        setupFirebaseListener();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: attempting to sign out the user");
                FirebaseAuth.getInstance().signOut();
            }
        });

        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();

    }

}
