package com.example.contact_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.contact_app.databinding.ActivityAddContactBinding;

public class AddContact extends AppCompatActivity {

    private ActivityAddContactBinding binding;

    private AppDatabase appDatabase;
    private ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddContactBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.editName.getText().toString();
                String phone = binding.editPhone.getText().toString();
                String mail = binding.editMail.getText().toString();

                appDatabase = AppDatabase.getInstance(getApplicationContext());
                contactDao = appDatabase.contactDAO();
                Contact contact = new Contact(name, phone, mail );
                contactDao.insert(contact);
                Toast.makeText(AddContact.this,"Inserted", Toast.LENGTH_SHORT).show();

                boolean Inserted = true;

                Intent intent = new Intent(AddContact.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}