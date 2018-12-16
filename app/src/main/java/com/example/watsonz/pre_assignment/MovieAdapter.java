package com.example.watsonz.pre_assignment;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.watsonz.pre_assignment.databinding.ItemMovieListBinding;

import java.util.ArrayList;
import java.util.List;

import model.MovieItem;
import model.MovieList;
import retrofit2.http.Url;
import viewmodel.MainViewModel;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private final List<MovieItem> moviesList;
    private int layoutId;
    private MainViewModel viewModel;

    public MovieAdapter(@LayoutRes int layoutId, MainViewModel viewModel) {
        this.moviesList = new ArrayList<>();
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    public void updateItems(MovieList items) {
        this.moviesList.clear();
        this.moviesList.addAll(items.getMovieList());

        notifyDataSetChanged();
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieAdapter.ViewHolder(ItemMovieListBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder holder, int position) {
        MovieItem movie = moviesList.get(position);
        holder.bind(movie);
        holder.binding.Linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = movie.link;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemMovieListBinding binding;

        ViewHolder(ItemMovieListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(MovieItem movie) {
            binding.setVariable(BR.movie,movie);
        }
    }


}