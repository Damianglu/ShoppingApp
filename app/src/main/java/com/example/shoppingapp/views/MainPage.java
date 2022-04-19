package com.example.shoppingapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shoppingapp.admin.AdminScreen;
import com.example.shoppingapp.R;
import com.example.shoppingapp.shopper.ShopperScreen;

public class MainPage extends AppCompatActivity {

    Button madminButton, muserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        madminButton = findViewById(R.id.adminButton);
        muserButton = findViewById(R.id.userButton);

        madminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainPage.this, AdminScreen.class));
            }
        });

        muserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainPage.this, ShopperScreen.class));
            }
        });
    }
}