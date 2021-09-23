package com.example.bigbrother;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogOut = findViewById(R.id.btnLogout);
        if (FirebaseAuth.getInstance().getCurrentUser()== null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else {
            Toast.makeText(MainActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
            btnLogOut.setOnClickListener(view ->{
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "User logged out successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            });
        }
    }
}