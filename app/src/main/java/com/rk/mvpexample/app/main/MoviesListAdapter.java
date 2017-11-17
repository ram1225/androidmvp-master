package com.rk.mvpexample.app.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.rk.mvpexample.app.R;
import com.rk.mvpexample.app.service.MoviesApiCall;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesViewHolder> {
    private Context context;
    private List<ResultsItem> mMovieItems;

    public MoviesListAdapter(Context context, List<ResultsItem> mMovieItems) {
        this.context = context;
        this.mMovieItems=mMovieItems;
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {


        public TextView mMovieTitle;
        public ImageView mMoviePosterPath;

        public MoviesViewHolder(View view) {
            super(view);
            mMovieTitle = (TextView) view.findViewById(R.id.movie_name);
            mMoviePosterPath = (ImageView) view.findViewById(R.id.movie_image);
        }
    }

    @Override
    public MoviesListAdapter.MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mMovieItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MoviesViewHolder(mMovieItemView);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        ResultsItem mMovieItem = mMovieItems.get(position);
        holder.mMovieTitle.setText(mMovieItem.getTitle());
        Picasso.with(this.context).load(MoviesApiCall.mBaseUrl+"3"+mMovieItem.getPosterPath()).into(holder.mMoviePosterPath);
    }

    @Override
    public int getItemCount() {
        return mMovieItems.size();
    }
}