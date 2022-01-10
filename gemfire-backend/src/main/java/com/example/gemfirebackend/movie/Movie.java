package com.example.gemfirebackend.movie;

import com.example.gemfirebackend.cast.Cast;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getPlot() {
        return plot;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
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
