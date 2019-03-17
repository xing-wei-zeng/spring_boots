package com.zingw.demo.service.impl;

import com.zingw.demo.mapper.MovieMapper;
import com.zingw.demo.pojo.Movies;
import com.zingw.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxw
 * @Desriiption:
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movies> findAllMovie() {
        return movieMapper.findAllMovie();
    }

    @Override
    public List<Movies> getMovieByname(String name) {
        return movieMapper.getMovieByname(name);
    }

    @Override
    public Movies insertMovie(Movies movies) {
        movieMapper.insertMovie(movies);
        return movies;
    }

    @Override
    public int updataMovie(Movies movies) {
        return movieMapper.updataMovie(movies);
    }

    @Override
    public int deleteMovieById(Integer id) {
        return movieMapper.deleteMovieById(id);
    }
}
