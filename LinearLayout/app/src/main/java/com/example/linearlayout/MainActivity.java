package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.linearlayout.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        binding.lvHistory.setAdapter(arrayAdapter);

        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editA.getText().toString();
                String b = binding.editB.getText().toString();
                int resutl = (Integer.parseInt(a) + Integer.parseInt(b));

                arrayList.add(a +" + "+ b +" = " +resutl);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editA.getText().toString();
                String b = binding.editB.getText().toString();
                int resutl = (Integer.parseInt(a) - Integer.parseInt(b));

                arrayList.add(a +" - "+ b +" = " +resutl);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnMultil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editA.getText().toString();
                String b = binding.editB.getText().toString();
                float resutl = (Integer.parseInt(a) * Integer.parseInt(b));

                arrayList.add(a +" * "+ b +" = " +resutl);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnDivisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editA.getText().toString();
                String b = binding.editB.getText().toString();
                float resutl = (Integer.parseInt(a) / Integer.parseInt(b));

                arrayList.add(a +" / "+ b +" = " +resutl);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}