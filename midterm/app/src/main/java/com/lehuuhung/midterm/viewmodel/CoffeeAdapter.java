package com.lehuuhung.midterm.viewmodel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lehuuhung.midterm.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lehuuhung.midterm.model.Coffee;

import java.util.ArrayList;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder>{

    private ArrayList<Coffee> coffeeList;

    public CoffeeAdapter(ArrayList<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    @NonNull
    @Override
    public CoffeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeAdapter.ViewHolder holder, int position) {
        Coffee coffee = coffeeList.get(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView delete,edit;
        public ViewHolder(View view) {
            super(view);
            delete = (ImageView) view.findViewById(R.id.iv_delete);
        }

    }
}
