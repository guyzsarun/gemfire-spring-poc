package com.example.gemfirebackend.movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import org.springframework.web.client.RestTemplate;


@Service
public class MovieService {
    @Autowired
    private Environment env;

    @Cacheable("movie")
    public String getAllData(String key) {
        String url = "https://imdb8.p.rapidapi.com/auto-complete?q={q}";

        HttpHeaders headers = new HttpHeaders();

        headers.set("x-rapidapi-host",env.getProperty("api.rapid.host"));
        headers.set("x-rapidapi-key",env.getProperty("api.rapid.key"));

        HttpEntity request = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                key
                );
        System.out.println(result);
        return result.toString();
    }
}

