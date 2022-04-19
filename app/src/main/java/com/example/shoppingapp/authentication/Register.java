package com.example.shoppingapp.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingapp.R;
import com.example.shoppingapp.models.User;
import com.example.shoppingapp.views.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText mfullName, memailAddress, mshippingAddress, mphoneNumber, mregisterPassword;
    private Button mregisterButton;
    private TextView mLoginTextView;

private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mfullName = findViewById(R.id.fullName);
        memailAddress = findViewById(R.id.emailAddress);
        mshippingAddress = findViewById(R.id.shippingAddress);
        mphoneNumber = findViewById(R.id.phoneNumber);
        mregisterPassword = findViewById(R.id.registerPassword);

        mregisterButton = findViewById(R.id.registerButton);

        mLoginTextView = findViewById(R.id.LoginTextView);

        firebaseAuth = FirebaseAuth.getInstance();

        mLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
            }
        });

        mregisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = mfullName.getText().toString().trim();
                String email = memailAddress.getText().toString().trim();
                String address = mshippingAddress.getText().toString().trim();
                String phone = mphoneNumber.getText().toString().trim();
                String password = mregisterPassword.getText().toString().trim();

                if(fullName.isEmpty() || email.isEmpty() || address.isEmpty() || phone.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "All fields must be filled out",Toast.LENGTH_SHORT).show();
                }
                else if(password.length()<6)
                {
                    Toast.makeText(getApplicationContext(), "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                User user = new User(fullName, email, address, phone, password);

                                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);

                                Toast.makeText(getApplicationContext(), "Registration succesful", Toast.LENGTH_SHORT).show();
                                sendEmailVerification();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Registration unsuccesful", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }
            }
        });
    }

    private void sendEmailVerification()
    {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(), "Email verification sent succesfuly", Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(Register.this, MainActivity.class));
                }
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Failed to send verification email", Toast.LENGTH_SHORT).show();

        }
    }
}