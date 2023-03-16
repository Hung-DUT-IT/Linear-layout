package com.lehuuhung.midterm.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.lehuuhung.midterm.R;
import com.lehuuhung.midterm.databinding.FragmentDeltaiBinding;
import com.lehuuhung.midterm.databinding.FragmentMianBinding;

public class deltaiFragment extends Fragment {
    private FragmentDeltaiBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDeltaiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //boolean addWhip = false ;
        //boolean addCream ;
        binding.cbCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (binding.cbCream.isChecked()){
                    boolean addCream = true;
                }
                else {
                    boolean addCream = false;
                }
            }
        });
        binding.cbChocolate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (binding.cbChocolate.isChecked()){
                    boolean addWhip = true;
                }
                else {
                    boolean addWhip = false;
                }
            }
        });
    }
}