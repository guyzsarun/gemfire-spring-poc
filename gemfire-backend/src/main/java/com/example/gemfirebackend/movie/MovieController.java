package com.example.gemfirebackend.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public String getMovie() throws URISyntaxException {
        movieService.getAllData("test");
        return "200";
    }
}
