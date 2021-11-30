package com.example.gemfirebackend.movie;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping(path = "api/movie")
public class MovieController {
    Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    MovieService movieService;

    @GetMapping
    public Map<String, Object> getMovie(@RequestParam(value = "name", required = false , defaultValue = "") String name)
    {
        long start = System.currentTimeMillis();

        JSONObject jsonObject = new JSONObject(movieService.getAllData(name));

        long delay = System.currentTimeMillis() - start;

        logger.info("Backend API Requested Time : {} ms",delay);

        jsonObject.put("delay(ms)",delay);
        if( jsonObject.has("d")){
            JSONArray array= (JSONArray) jsonObject.get("d");
            for(Object o: array){
                if ( o instanceof JSONObject ) {
                    JSONObject object = (JSONObject) o;
                    Movie movie = new Movie(
                            (String) object.get("l"),
                            object.has("y") ?  object.get("y").toString() : "-",
                            object.has("rank") ?  object.get("rank").toString() : "-",
                            (String) object.get("id"),
                            (String)object.getJSONObject("i").get("imageUrl")
                    );
                    System.out.println(movie.toString());
                }
            }
        }
        return jsonObject.toMap();


    }
}
