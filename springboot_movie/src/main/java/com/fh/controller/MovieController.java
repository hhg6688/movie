package com.fh.controller;

import com.fh.model.Movie;
import com.fh.model.Query;
import com.fh.service.MovieService;
import com.fh.common.jsonData;
import com.fh.util.DataTableResult;
import com.fh.util.OSSUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("MovieController")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping("selectMovieAll")
    public DataTableResult selectMovieAll(Query query){
        DataTableResult movieList=movieService.selectMovieAll(query);
        return movieList;
    }


    @RequestMapping("uploadImage")
    public Map<String,Object> uploadUser2(MultipartFile image) {
        Map map = new HashMap();
        try {
            String fileName = OSSUtils.uploadFile(image);
            map.put("fileName",fileName);
            map.put("message",1);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("message",2);
        }
        return map;
    }

    @RequestMapping("addMovie")
    public jsonData addMovie(Movie movie){
        movieService.addMovie(movie);
        return jsonData.getJsonSuccess("新增成功");
    }

    @RequestMapping("updateMovie")
    public jsonData updateMovie(Integer id){
        movieService.updateMovie(id);
        return jsonData.getJsonSuccess("购买成功");
    }
}
