package com.balajidontul.controller;

import com.balajidontul.Dto.MovieView;
import com.balajidontul.Entity.Movie;
import com.balajidontul.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/catalog")
public class CatalogController {

    MoviesService moviesService;

    @Autowired
    CatalogController(MoviesService moviesService){
        this.moviesService = moviesService;
    }

    @GetMapping("movies")
    public Page<MovieView> getMovies(@RequestParam(defaultValue = "2") int page,
                                     @RequestParam(defaultValue = "10") int size){
        return moviesService.getMoviesList(page, size);
    }


}
