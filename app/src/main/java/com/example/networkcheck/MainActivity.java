package com.example.networkcheck;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = findViewById(R.id.internet);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkconnection();
            }
        });

    }

    private void Checkconnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (null!=networkInfo){
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(getApplicationContext(),"Data  CONNECTION Via Wi-Fi",Toast.LENGTH_LONG).show();
            }
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(getApplicationContext()," Data  Connection Via Mobile",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
        }
    }
}