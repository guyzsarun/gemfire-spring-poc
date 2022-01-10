package com.example.gemfirebackend.cast;

public class Cast {
    public String originalName;
    public String movieName;

    public Cast(String originalName,String movieName){
        this.originalName=originalName;
        this.movieName=movieName;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "originalName=" + originalName +
                ", movieName='" + movieName  +
                '}' + '\n';
    }
}
