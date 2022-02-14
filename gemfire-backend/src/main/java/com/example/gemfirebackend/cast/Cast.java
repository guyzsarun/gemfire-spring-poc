package com.example.gemfirebackend.cast;

public class Cast {
    private String originalName;
    private String movieName;

    public Cast(String originalName,String movieName){
        this.originalName=originalName;
        this.movieName=movieName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "originalName=" + originalName +
                ", movieName='" + movieName  +
                '}' + '\n';
    }
}
