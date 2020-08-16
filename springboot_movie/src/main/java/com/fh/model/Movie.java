package com.fh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@TableName("tt_movie")
public class Movie {
    @TableId(value = "mId",type = IdType.AUTO)

    private Integer mId;
    @TableField("mName")
    private String mName;
    @TableField("showTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showTime;
    @TableField("mNum")
    private Integer mNum;
    @TableField("price")
    private Integer price;
    @TableField("showHome")
    private Integer showHome;
    @TableField("imgUrl")
    private String imgUrl;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Integer getmNum() {
        return mNum;
    }

    public void setmNum(Integer mNum) {
        this.mNum = mNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getShowHome() {
        return showHome;
    }

    public void setShowHome(Integer showHome) {
        this.showHome = showHome;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
