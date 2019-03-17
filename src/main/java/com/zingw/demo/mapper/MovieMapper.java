package com.zingw.demo.mapper;

import com.zingw.demo.pojo.Movies;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zxw
 * @Desriiption:
 */
@Mapper
public interface MovieMapper {
    List<Movies> findAllMovie();

    List<Movies> getMovieByname(String name);

    int insertMovie(Movies movies);

    int updataMovie(Movies movies);

    int deleteMovieById(Integer id);
}
