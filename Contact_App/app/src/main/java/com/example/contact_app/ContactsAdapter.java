package com.example.contact_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Contact> contactList;

    public ContactsAdapter(Context context, ArrayList<Contact> contactList) {
        this.contactList = contactList;
        this.context = context;
    }

    public void setFilterList(List<Contact> filterList){
        this.contactList = (ArrayList<Contact>) filterList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder holder, int position) {

        Contact contact = contactList.get(position);

        holder.tvName.setText(contact.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailContact.class);
                i.putExtra("name", contact.getName());
                i.putExtra("phone", contact.getMobile());
                i.putExtra("mail", contact.getEmail());
                // on below line we are starting a new activity,
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase appDatabase = AppDatabase.getInstance(context);
                ContactDao contactDao = appDatabase.contactDAO();
                contactDao.delete(contact.getId());

                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, UpdateContact.class);
                i.putExtra("name", contact.getName());
                i.putExtra("phone", contact.getMobile());
                i.putExtra("mail", contact.getEmail());
                // on below line we are starting a new activity,
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView delete,edit;
        public ViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            delete = (ImageView) view.findViewById(R.id.iv_delete);
            edit = (ImageView) view.findViewById(R.id.iv_edit);
        }

    }
}
