package com.example.gemfirebackend.movie;

public class Movie {
    private String title;
    private String year;
    private String rank;
    private String id;
    private String poster;

    public Movie(String title,String year,String rank,String id,String poster){
        this.id=id;
        this.rank=rank;
        this.title=title;
        this.year=year;
        this.poster=poster;
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rank='" + rank + '\'' +
                ", year=" + year + '\n' +
                ", poster=" + poster +
                '}';
    }
}
