package com.fh.model;

import com.fh.util.DataTablePageBean;

public class Query extends DataTablePageBean {

private String mName;

private Integer showHome;


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getShowHome() {
        return showHome;
    }

    public void setShowHome(Integer showHome) {
        this.showHome = showHome;
    }
}
