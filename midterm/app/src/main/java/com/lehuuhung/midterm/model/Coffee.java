package com.lehuuhung.midterm.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Coffee {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private boolean addWhip;

    @ColumnInfo
    private boolean addCho;

    @ColumnInfo
    private int quantity;

    @ColumnInfo
    private int price;

    @ColumnInfo
    private String status;

    public Coffee(int id, boolean addWhip, boolean addCho, int quantity, int price, String status) {
        this.id = id;
        this.addWhip = addWhip;
        this.addCho = addCho;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAddWhip() {
        return addWhip;
    }

    public void setAddWhip(boolean addWhip) {
        this.addWhip = addWhip;
    }

    public boolean isAddCho() {
        return addCho;
    }

    public void setAddCho(boolean addCho) {
        this.addCho = addCho;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
