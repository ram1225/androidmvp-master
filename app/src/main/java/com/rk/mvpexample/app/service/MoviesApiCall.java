package com.rk.mvpexample.app.service;

import com.rk.mvpexample.app.main.Response;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MoviesApiCall {
   public static String mBaseUrl = "https://api.themoviedb.org/";

    public interface MoviesApi {
        @GET("3/movie/now_playing?page=1&api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed")
        Call<Response> getMoviesList();
    }

    public MoviesApi getAPI() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit.create(MoviesApi.class);
    }
}

