package com.codepath.movies.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codepath.movies.presenter.MovieListPresenter;
import com.codepath.movies.rest.ApiClient;
import com.codepath.movies.rest.ApiInterface;
import com.codepath.movies.model.Movie;
import com.codepath.movies.adapter.MovieAdapter;
import com.codepath.movies.rest.MoviesResponse;
import com.codepath.movies.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MovieAdapter.OnItemClickListener {


    private static final String TAG = "MainActivity";

    private List<Movie> movies = new ArrayList<>();
    private MovieAdapter movieAdapter;
    private MovieListPresenter movieListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListPresenter = new MovieListPresenter(this);

        final RecyclerView recyclerView = findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieAdapter = new MovieAdapter(getApplicationContext(), this);

        recyclerView.setAdapter(movieAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();


        movieListPresenter.loadMovieList(new MovieListPresenter.OnLoadMovieListListener() {
            @Override
            public void onLoadMovieListener(List<Movie> movieList) {
                movies.clear();
                movies.addAll(movieList);
                movieAdapter.setData(movies);
                movieAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        int id = movies.get(position).getId();
        intent.putExtra("movieId", id);
        startActivity(intent);
    }
}
