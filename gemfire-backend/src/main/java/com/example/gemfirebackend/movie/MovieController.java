package com.example.gemfirebackend.movie;

import org.json.JSONArray;
import org.json.JSONObject;
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

    @Autowired
    MovieService movieService;

    @GetMapping
    public Map<String, Object> getMovie(@RequestParam(value = "name", required = false , defaultValue = "") String name)
    {
        long start = System.currentTimeMillis();

        JSONObject jsonObject = new JSONObject(movieService.getAllData(name));

        long delay = System.currentTimeMillis() - start;

        System.out.printf("Backend API Requested Time : %dms %n",delay);

        jsonObject.put("delay(ms)",delay);


        if( jsonObject.has("d")){
            JSONArray array= (JSONArray) jsonObject.get("d");
            System.out.print(array.length());
        }
        return jsonObject.toMap();


    }
}
