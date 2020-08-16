package com.fh.service.Impl;

import com.fh.dao.MovieDao;
import com.fh.model.Movie;
import com.fh.model.Query;
import com.fh.service.MovieService;
import com.fh.util.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    public DataTableResult selectMovieAll(Query query) {
        Long count=movieDao.selectMovieCount(query);
        List<Movie> movieList=movieDao.selectListAll(query);
        DataTableResult dataTableResult=new DataTableResult(query.getDraw(),count,count,movieList);
        return dataTableResult;
    }

    @Override
    public void addMovie(Movie movie) {
        movieDao.insertMovie(movie);
    }

    @Override
    public void updateMovie(Integer id) {
        movieDao.updateMovie(id);
    }
}
