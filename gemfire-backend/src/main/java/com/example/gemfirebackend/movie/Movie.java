package com.example.gemfirebackend.movie;

import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String year;
    private String rank;
    private String id;
    private String poster;

    private String[] actor;

    public Movie(String title,String year,String rank,String id,String poster,String actor){
        this.id=id;
        this.rank=rank;
        this.title=title;
        this.year=year;
        this.poster=poster;
        this.actor= Arrays.stream(actor.split(","))
                .map(String::trim)
                .toArray(String[]::new);
    }


    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getYear() {
        return year;
    }

    public String getRank() {
        return rank;
    }

    public String getId() {
        return id;
    }

    public String[] getActor(){return actor;}

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
