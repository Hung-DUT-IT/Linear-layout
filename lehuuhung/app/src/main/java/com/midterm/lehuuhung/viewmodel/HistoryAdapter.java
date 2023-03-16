package com.midterm.lehuuhung.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.lehuuhung.R;
import com.midterm.lehuuhung.model.History;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    private static ArrayList<History> HistoryList;
    public HistoryAdapter(ArrayList<History> historyList) {
        HistoryList = historyList;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        History history = HistoryList.get(position);

        holder.tvNumber.setText( Integer.toString(history.getId()) );
        holder.tvInput.setText(history.getInput());
        holder.tvAction.setText(history.getAction());
        holder.tvOutput.setText(history.getOutput());

        holder.imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HistoryList.remove(history);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return HistoryList.size();
    }

    public void clear() {
        HistoryList.clear();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNumber, tvInput, tvAction, tvOutput;
        public ImageView imgDel;
        public ViewHolder(View view) {
            super(view);
            tvNumber = (TextView) view.findViewById(R.id.tv_number);
            tvInput = (TextView) view.findViewById(R.id.tv_input);
            tvAction = (TextView) view.findViewById(R.id.tv_action);
            tvOutput = (TextView) view.findViewById(R.id.tv_output);
            imgDel = (ImageView) view.findViewById(R.id.iv_delete);
        }

    }
}
