package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView detailNama, detailRilis, detailDeskripsi;
    private ImageView detailGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        detailNama = findViewById(R.id.detailNama_id);
        detailRilis = findViewById(R.id.detailRilis_id);
        detailDeskripsi = findViewById(R.id.detailDeskripsi_id);
        detailGambar = findViewById(R.id.detailGambar_id);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String nama = movie.getNama();
        String rilis = movie.getRilis();
        String deskripsi = movie.getDeskripsi();
        int gambar = movie.getGambar();

        detailNama.setText(nama);
        detailRilis.setText(rilis);
        detailDeskripsi.setText(deskripsi);
        detailGambar.setImageResource(gambar);

    }
}
