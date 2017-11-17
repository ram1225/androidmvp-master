package com.rk.mvpexample.app.main;

import java.util.List;

public class MovieItem {

    private List<MovieItem> result;
    public String movieTitle;
    public String moviePosterPath;

    public List<MovieItem> getResult(){
        return result;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMoviePosterPath() {
        return moviePosterPath;
    }

    public void setMoviePosterPath(String moviePosterPath) {
        this.moviePosterPath = moviePosterPath;
    }
}