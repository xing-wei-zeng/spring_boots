package com.zingw.demo.repository;

import com.zingw.demo.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zxw
 * @Desriiption:
 */
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie>  findByNameIsLike(String name);
}
