package com.balajidontul.service;

import com.balajidontul.Dto.MovieView;
import com.balajidontul.repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {
    int MAX_PAGE_SIZE = 20;
    MoviesRepo moviesRepo;

    @Autowired
    MoviesService(MoviesRepo moviesRepo){
        this.moviesRepo = moviesRepo;
    }

    public Page<MovieView> getMoviesList(int pageNo, int pageSize){
        int size = Math.clamp(pageSize, 1, MAX_PAGE_SIZE);
        Pageable pageable = PageRequest.of(pageNo,size, Sort.by("title").ascending());
        return moviesRepo.findAll(pageable).map(MovieView::convert);
    }
}
