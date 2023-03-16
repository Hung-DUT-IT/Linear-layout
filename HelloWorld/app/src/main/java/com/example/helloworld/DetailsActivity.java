package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.helloworld.databinding.ActivityDetailsBinding;
import com.example.helloworld.databinding.ActivityMainBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private MyViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent receivedIntent = getIntent();

        if(receivedIntent != null )
        {
            String data = receivedIntent.getStringExtra("number");
            binding.editText.setText(data);
        }
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = binding.editText.getText().toString();

                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putExtra("number",number);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}