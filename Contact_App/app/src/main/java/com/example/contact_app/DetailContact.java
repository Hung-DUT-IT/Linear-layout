package com.example.contact_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.contact_app.databinding.ActivityDetailContactBinding;

public class DetailContact extends AppCompatActivity {

    private ActivityDetailContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailContactBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Intent receivedIntent = getIntent();
        if(receivedIntent != null )
        {
            String name = receivedIntent.getStringExtra("name");
            binding.editName.setText(name);

            String phone = receivedIntent.getStringExtra("phone");
            binding.editPhone.setText(phone);

            String mail = receivedIntent.getStringExtra("mail");
            binding.editMail.setText(name);
        }

    }
}