package com.example.gemfirebackend.movie;

public class Movie {
    private String title;
    private int year;
    private int rank;
    private String id;

    public Movie(String title,int year,int rank,String id){
        this.id=id;
        this.rank=rank;
        this.title=title;
        this.year=year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getRank() {
        return rank;
    }

    public String getId() {
        return id;
    }
}
