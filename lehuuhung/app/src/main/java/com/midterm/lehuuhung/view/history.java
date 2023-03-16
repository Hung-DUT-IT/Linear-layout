package com.midterm.lehuuhung.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.midterm.lehuuhung.R;
import com.midterm.lehuuhung.databinding.FragmentHistoryBinding;
import com.midterm.lehuuhung.model.History;
import com.midterm.lehuuhung.viewmodel.HistoryAdapter;
import com.midterm.lehuuhung.viewmodel.HistoryModel;

import java.util.ArrayList;
import java.util.List;

public class history extends Fragment{

    private FragmentHistoryBinding binding;
    private HistoryAdapter historyAdapter;
    private ArrayList<History> historyList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        historyList = new ArrayList<>();
        historyAdapter = new HistoryAdapter(historyList);

        binding.rvHistory.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvHistory.setAdapter(historyAdapter);

        ArrayList<History> historyListReceiver = getArguments().getParcelableArrayList("histories");
        if (!historyListReceiver.isEmpty()) {
            historyAdapter = new HistoryAdapter(historyListReceiver);

            binding.rvHistory.setAdapter(historyAdapter);
        }
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_history_to_main);
            }
        });
        binding.ivDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyAdapter.clear();
                historyAdapter.notifyDataSetChanged();
            }
        });
    }
}