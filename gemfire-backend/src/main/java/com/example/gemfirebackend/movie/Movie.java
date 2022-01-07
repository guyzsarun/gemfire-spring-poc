package com.example.gemfirebackend.movie;

import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

public class Movie {
    private String id;
    private String title;
    private String year;
    private String duration;
    private String poster;
    private String rating;
    private String imdbRating;
    private String[] genres;
    private String plot;

    private Object[] cast;

    public Movie(String id,String title,String year,String duration,String poster,String rating, String imdbRating,String genres,String plot,Object[] cast ){
        this.id=id;
        this.title=title;
        this.year=year;
        this.duration=duration;
        this.poster=poster;
        this.rating=rating;
        this.imdbRating=imdbRating;
        this.genres=genres;
        this.plot=plot;

        this.cast=cast;
//        this.actor= Arrays.stream(actor.split(","))
//                .map(String::trim)
//                .toArray(String[]::new);
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", actor='" + actor + '\n' +
                ", rank='" + rank + '\'' +
                ", year=" + year + '\n' +
                ", poster=" + poster +
                '}';
    }
}
