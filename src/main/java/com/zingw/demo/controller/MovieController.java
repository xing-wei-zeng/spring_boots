package com.zingw.demo.controller;

import com.zingw.demo.pojo.Movies;
import com.zingw.demo.service.MovieService;
import com.zingw.demo.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author zxw
 * @Desriiption:
 */
@RestController
@Validated
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MessageSource messageSource;

    private ErrorCode errorCode = new ErrorCode();

    /**
     *  查询所有电影
     * @return
     */
    @GetMapping(value = "/movies")
    public List<Movies> findAllMovie(){
        return movieService.findAllMovie();
    }

    /**
     *  添加一部电影
     * @return
     */
    @PostMapping(value = "/addmovies")
    public Movies insertMovie(@Valid Movies movies,BindingResult bindingResult){
        return movieService.insertMovie(movies);
    }

    /**
     *  通过电影名查找一部电影
     * @return
     */
    @GetMapping(value = "/movies/{name}")
    public List<Movies> getMovieByname(@Size(min = 1,max = 30,message = "名字长度必须为1到30")@PathVariable("name")String name){
        return movieService.getMovieByname(name);
    }

    /**
     *  更新电影
     * @return
     */
    @PostMapping(value = "/updatemovies")
    public String updataMovie(@Valid Movies movies,BindingResult bindingResult){
        movieService.updataMovie(movies);
        return errorCode.getMeg(bindingResult);
    }

    /**
     *  删除电影
     * @return
     */
    @GetMapping(value = "/deletemovies")
    public String deleteMovieById(@Min(value = 1,message = "id最小为1") Integer id){
        int result = movieService.deleteMovieById(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
