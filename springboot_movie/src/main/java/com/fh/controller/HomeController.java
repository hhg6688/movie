package com.fh.controller;

import com.alibaba.fastjson.JSONObject;
import com.fh.model.Home;
import com.fh.service.HomeService;
import com.fh.common.jsonData;
import com.fh.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;

@RestController
@RequestMapping("HomeController")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping("selectMovieHome2")
    public jsonData selectMovieHome(){
        Jedis jedis = RedisUtils.getJedis();
        List<Home> homeList=homeService.selectMovieHome();
        String sale = JSONObject.toJSONString(homeList);
        jedis.set("home",sale);
    return jsonData.getJsonSuccess("刷新成功");
    }


    //查询全部的类型
    @RequestMapping("selectMovieHome")
    public jsonData selectHome(){
        Jedis jedis = RedisUtils.getJedis();
        String home = jedis.get("home");
        RedisUtils.returnJedis(jedis);
        return jsonData.getJsonSuccess(home);
    }
}
