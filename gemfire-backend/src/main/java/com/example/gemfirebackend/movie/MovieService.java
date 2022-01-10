package com.example.gemfirebackend.movie;


import com.example.gemfirebackend.cast.Cast;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {

    @Autowired
    private Environment env;

    @Cacheable("movie")
    public String getAllData(String key) {
        return requestBuilder("find","q",key);
    }

    @Cacheable("plots")
    public String getPlot(String key) {
        return requestBuilder("get-plots", "tconst", key);
    }

    @Cacheable("ratings")
    public String getRatings(String key){
        return requestBuilder("get-ratings","tconst",key);
    }

    public Movie parseRequest(JSONObject movie){
        String id = movie.get("id").toString().split("/")[2];
        String title = (String) movie.get("title");
        String year =  movie.has("year") ? movie.get("year").toString() : "-";
        String duration = movie.has("runningTimeInMinutes")? movie.get("runningTimeInMinutes").toString(): "-";
        String poster = movie.getJSONObject("image").get("url").toString();


        JSONArray array= (JSONArray) movie.get("principals");
        List<Cast> casts= new ArrayList<Cast>();

        for(Object c: array){
            if ( c instanceof JSONObject ){
                JSONObject cast = (JSONObject) c;

                String originalName=cast.get("name").toString();
                String movieName=cast.getJSONArray("characters").get(0).toString();

                casts.add(new Cast(originalName,movieName));

            }
        }

        return new Movie(id,title,year,duration,poster,casts);
    }

    public String parsePlots(String plots){
        JSONObject jsonPlot = new JSONObject(plots);

        return jsonPlot.getJSONArray("plots").length()!=0? jsonPlot.getJSONArray("plots").getJSONObject(0).get("text").toString() : "";
    }

    public String requestBuilder(String path,String req,String key){
        String url = "https://imdb8.p.rapidapi.com/title/"+path+"?"+req+"={q}";

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

        return result.getBody();
    }
}

