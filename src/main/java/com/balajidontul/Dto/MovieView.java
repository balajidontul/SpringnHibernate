package com.balajidontul.Dto;

import com.balajidontul.Entity.Movie;

public record MovieView(Long id, String title, Integer year, String genre) {

    public static MovieView convert(Movie m) {
        return new MovieView(
                m.getId(),
                m.getTitle(),
                m.getYear(),
                m.getGenre()
        );
    }
}
