package model;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    public List<MovieItem> movieList;

    public MovieList() {
        this.movieList = new ArrayList<>();
    }

    public void add(MovieItem item) {
        this.movieList.add(item);
    }

    public List<MovieItem> getMovieList()
    {
        return this.movieList;
    }
}
