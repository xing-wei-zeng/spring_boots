package com.zingw.demo.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zxw
 * @Desriiption:
 */
public class SysLog implements Serializable {
    private String description;
    private String type;
    private String ip;
    private Integer movieid;
    private Date time;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
