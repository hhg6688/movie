package com.fh.service.Impl;

import com.fh.dao.HomeDao;
import com.fh.model.Home;
import com.fh.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDao homeDao;

    @Override
    public List<Home> selectMovieHome() {
        return  homeDao.selectList(null);
    }
}
