package com.zingw.demo.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author zxw
 * @Desriiption:
 */

public class Movies {

    @Min(value = 1,message = "ID最小为1")
    private Integer id;//主键ID
    private String createDate;

    @Length(min = 1, max = 30, message = "名称长度为1-30位。")
    private String name;//名称

    @Length(min = 1, max = 30, message = "封面长度为1-30位。")
    private String photo;//封面

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
