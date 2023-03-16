package com.lehuuhung.midterm.view;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lehuuhung.midterm.R;
import com.lehuuhung.midterm.databinding.FragmentMianBinding;
import com.lehuuhung.midterm.model.Coffee;
import com.lehuuhung.midterm.viewmodel.AppDatabase;
import com.lehuuhung.midterm.viewmodel.CoffeeAdapter;
import com.lehuuhung.midterm.viewmodel.CoffeeDao;

import java.util.ArrayList;

public class mianFragment extends Fragment {

    private FragmentMianBinding binding;

    private CoffeeAdapter coffeeAdapter;
    private ArrayList<Coffee> coffeeList;

    private AppDatabase appDatabase;
    private CoffeeDao coffeeDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMianBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        coffeeList = new ArrayList<>();

        binding.rvOder.setLayoutManager(new LinearLayoutManager(getActivity()));

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase = AppDatabase.getInstance(getActivity().getApplicationContext());
                coffeeDao = appDatabase.coffeeDao();

                coffeeList = (ArrayList<Coffee>) coffeeDao.getAll();
                coffeeAdapter = new CoffeeAdapter(coffeeList);
                binding.rvOder.setAdapter(coffeeAdapter);
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_mianFragment_to_deltaiFragment);
            }
        });
    }
}