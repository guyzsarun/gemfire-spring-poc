package com.example.gemfirebackend.movie;

import com.example.gemfirebackend.cast.Cast;

import java.util.List;

public class Movie {
    public String id;
    public String title;
    public String year;
    public String duration;
    public String poster;
    public String rating;
    public String imdbRating;
    public String[] genres;
    public String plot;

    public List<Cast> cast;

    public Movie(String id,String title,String year,String duration,String poster,List<Cast> cast ){
        this.id=id;
        this.title=title;
        this.year=year;
        this.duration=duration;
        this.poster=poster;
        this.cast=cast;
    }

    public String getId(){
        return this.id;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id + '\n' +
                ", title=" + title  + '\n' +
                ", duration=" + duration + '\n' +
                ", year=" + year + '\n' +
                ", poster=" + poster + '\n' +
                ", plot=" + plot + '\n' +
                ", cast=" + cast +
                '}' + '\n';
    }
}
