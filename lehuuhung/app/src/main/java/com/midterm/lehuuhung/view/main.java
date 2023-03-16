package com.midterm.lehuuhung.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.midterm.lehuuhung.R;
import com.midterm.lehuuhung.databinding.FragmentMainBinding;
import com.midterm.lehuuhung.model.History;
import com.midterm.lehuuhung.viewmodel.Handle;
import com.midterm.lehuuhung.viewmodel.HistoryModel;

import java.util.ArrayList;

public class main extends Fragment {

    private FragmentMainBinding binding;
    private ArrayList<History> historyList;
    private Handle handle = new Handle();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        historyList = new ArrayList<>();
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = binding.editInput.getText().toString();
                String action = binding.editAction.getText().toString();
                if(TextUtils.isEmpty(input) | TextUtils.isEmpty(action)) {
                    Toast.makeText(getActivity(),"\n" + "Input and Action cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (action.equals("count-letter-digit"))
                    {
                        int countLetter = handle.countLetter(input);
                        int countDigit = handle.countDigit(input);
                        String outPut = "LETTERS: "+ countLetter + "\nDIGITS: " + countDigit ;
                        History history = new History(historyList.size() , input, action, outPut );

                        historyList.add(history);

                        binding.txOutput.setText(outPut);

                    }
                    else if (action.equals("remove-even"))
                    {
                        String odd = handle.removeEven(input);
                        String outPut = "List Odd: "+ odd;

                        History history = new History(historyList.size() , input, action, outPut );

                        historyList.add(history);

                        binding.txOutput.setText(outPut);
                    }
                }
            }
        });
        binding.btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("histories", historyList);

                Navigation.findNavController(view).navigate(R.id.action_main_to_history, bundle);
            }
        });
    }
}