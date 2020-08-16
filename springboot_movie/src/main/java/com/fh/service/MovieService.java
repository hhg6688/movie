package com.fh.service;

import com.fh.model.Movie;
import com.fh.model.Query;
import com.fh.util.DataTableResult;

public interface MovieService {
    DataTableResult selectMovieAll(Query query);

    void addMovie(Movie movie);

    void updateMovie(Integer id);
}
