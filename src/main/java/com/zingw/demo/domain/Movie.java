package com.zingw.demo.domain;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zxw
 * @Desriiption:
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;//主键ID

    @Column(length = 50)
    private String name;//名称

    private String photo;//封面

    @Temporal(value = TemporalType.DATE)
    private Date createDate;//发行日期

    public Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
