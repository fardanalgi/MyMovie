package com.example.mymovieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> mMovies;

    public void setmMovies(ArrayList<Movie> mMovies) {
        this.mMovies = mMovies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        mMovies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int i) {
        return mMovies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);

        return view;
    }

    private class ViewHolder {

        private TextView mNama, mDeskripsi;
        private ImageView mGambar;

        ViewHolder(View view) {
            mNama = (TextView) view.findViewById(R.id.nama_id);
            mDeskripsi = (TextView) view.findViewById(R.id.deskripsi);
            mGambar = (ImageView) view.findViewById(R.id.gambar_id);
        }

        void bind(Movie movie) {
            mNama.setText(movie.getNama());
            mDeskripsi.setText(movie.getDeskripsi());
            mGambar.setImageResource(movie.getGambar());
        }

    }

}
