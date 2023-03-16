package com.midterm.lehuuhung.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.midterm.lehuuhung.model.History;

import java.util.ArrayList;

public class HistoryModel extends ViewModel {

    private MutableLiveData<ArrayList<History>> historyList = new MutableLiveData<>();

    public void setUserList(ArrayList<History> history) {
        historyList.setValue(history);
    }

    public LiveData<ArrayList<History>> getUserList() {
        return historyList;
    }

    public void addHistory(History history) {
        ArrayList<History> itemList = historyList.getValue();
        itemList.add(history);
        historyList.setValue(itemList);
    }
//    public void removeHistory(History history) {
//        historyList.add(history);
//    }


}
