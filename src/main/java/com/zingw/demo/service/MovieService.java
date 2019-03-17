package com.zingw.demo.service;

import com.zingw.demo.pojo.Movies;

import java.util.List;

/**
 * @author zxw
 * @Desriiption:
 */
public interface MovieService {
    List<Movies> findAllMovie();

    List<Movies> getMovieByname(String name);

    Movies insertMovie(Movies movies);

    int updataMovie(Movies movies);

    int deleteMovieById(Integer id);
}
