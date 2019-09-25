package com.example.mymovieapp;


import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int gambar;
    private String nama;
    private String deskripsi;
    private String rilis;

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.gambar);
        dest.writeString(this.nama);
        dest.writeString(this.deskripsi);
        dest.writeString(this.rilis);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.gambar = in.readInt();
        this.nama = in.readString();
        this.deskripsi = in.readString();
        this.rilis = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
