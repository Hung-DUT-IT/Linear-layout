package com.midterm.lehuuhung.model;

import android.os.Parcel;
import android.os.Parcelable;

public class History implements Parcelable {

    private int id;
    private String input;
    private String action;
    private String output;

    public History(int id, String input, String action, String output) {
        this.id = id;
        this.input = input;
        this.action = action;
        this.output = output;
    }

    protected History(Parcel in) {
        id = in.readInt();
        input = in.readString();
        action = in.readString();
        output = in.readString();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(input);
        parcel.writeString(action);
        parcel.writeString(output);
    }
}
