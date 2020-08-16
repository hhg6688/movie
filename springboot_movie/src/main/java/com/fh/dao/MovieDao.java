package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Movie;
import com.fh.model.Query;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MovieDao extends BaseMapper<Movie> {
    Long selectMovieCount(Query query);

    List<Movie> selectListAll(Query query);

    void insertMovie(Movie movie);

    void updateMovie(Integer id);
}
