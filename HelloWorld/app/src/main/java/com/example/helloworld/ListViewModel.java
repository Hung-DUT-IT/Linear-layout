package com.example.helloworld;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ListViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Integer>> list;

    public LiveData<ArrayList<Integer>> getList() {
        if (list == null) {
            list = new MutableLiveData<ArrayList<Integer>>();
            list.setValue(new ArrayList<Integer>());
        }
        return list;
    }

    public void addList(Integer number)
    {
        ArrayList<Integer> newList = list.getValue();
        newList.add(number);
        list.setValue(newList);
    }
}
