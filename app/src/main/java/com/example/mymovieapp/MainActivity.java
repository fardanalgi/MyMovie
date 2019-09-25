package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private String[] dataNama, dataRilis, dataDeskripsi;
    private TypedArray dataGambar;
    private MovieAdapter mAdapter;
    private ArrayList<Movie> mMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("List Movie");
        }

        mAdapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.listview_id);
        listView.setAdapter(mAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MOVIE, mMovies.get(i));
                startActivity(intent);
            }
        });
    }

    private void prepare() {
        dataNama = getResources().getStringArray(R.array.data_nama);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataRilis = getResources().getStringArray(R.array.data_rilis);
        dataGambar = getResources().obtainTypedArray(R.array.data_gambar);
    }

    private void addItem() {
        mMovies = new ArrayList<>();

        for (int i = 0; i < dataNama.length; i++) {
            Movie movie = new Movie();
            movie.setGambar(dataGambar.getResourceId(i, -1));
            movie.setNama(dataNama[i]);
            movie.setRilis(dataRilis[i]);
            movie.setDeskripsi(dataDeskripsi[i]);
            mMovies.add(movie);
        }
        mAdapter.setmMovies(mMovies);

    }
}
