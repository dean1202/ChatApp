package com.example.chatproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    Button btn_register_open_app,btn_login_open_app;

    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        if (firebaseUser != null){
            Intent intent =new Intent(MainActivity.this,MainBasicActivity.class);
            startActivity(intent);
//            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_register_open_app= findViewById(R.id.btn_register_open_app);
        btn_login_open_app= findViewById(R.id.btn_login_open_app);
    }

    public void OnClickBtn_login_open_app(View view){
        Intent intent =new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent); 

    }

    public void OnClickBtn_register_open_app(View view){
        Intent intent =new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


}