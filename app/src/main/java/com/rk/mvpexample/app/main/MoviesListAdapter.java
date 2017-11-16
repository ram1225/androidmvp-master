package com.rk.mvpexample.app.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesViewHolder> {
    private Context context;
    private List<MovieItem> mMovieItems;

    public MoviesListAdapter(Context context) {
        this.context = context;
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
        MovieItem mMovieItem = mMovieItems.get(position);
        holder.mMovieTitle.setText(mMovieItem.getMovieTitle());
        Picasso.with(this.context).load(mMovieItem.getMoviePosterPath()).into(holder.mMoviePosterPath);
    }

    @Override
    public int getItemCount() {
        return mMovieItems.size();
    }
}