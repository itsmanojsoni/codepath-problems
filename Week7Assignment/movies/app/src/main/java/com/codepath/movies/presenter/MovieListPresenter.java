package com.codepath.movies.presenter;


import android.content.Context;
import android.util.Log;
import android.view.View;

import com.codepath.movies.model.Movie;
import com.codepath.movies.rest.ApiClient;
import com.codepath.movies.rest.ApiInterface;
import com.codepath.movies.rest.MoviesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListPresenter {

    private static final String TAG = MovieListPresenter.class.getSimpleName();
    private Context context;
    public final static String API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";

    public MovieListPresenter(Context context) {
        this.context = context;
    }

    public interface OnLoadMovieListListener {
        void onLoadMovieListener(List<Movie> movieList);
    }


    public void loadMovieList(final OnLoadMovieListListener listener) {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getLatestMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (listener != null) {
                    listener.onLoadMovieListener(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
