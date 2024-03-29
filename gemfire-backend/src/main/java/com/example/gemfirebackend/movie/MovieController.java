package com.example.gemfirebackend.movie;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "api/movie")
@OpenAPIDefinition
public class MovieController {
    Logger logger = LoggerFactory.getLogger(MovieController.class);

    int limit = 2;

    @Autowired
    MovieService movieService;

    @GetMapping
    @Operation(summary = "Get Movies", description = "Get movies by title", responses={
            @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json")),
            @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
    })
    public Map<String, Object> getMovie(@RequestParam(value = "name", required = false , defaultValue = "") String name)
    {

        long start = System.currentTimeMillis();
        JSONObject response = new JSONObject();
        JSONArray movieList = new JSONArray();
        try {

            JSONObject jsonObject = new JSONObject(movieService.getAllData(name));

            if (jsonObject.has("results")) {
                JSONArray array = (JSONArray) jsonObject.get("results");
                int i=0;
                for (Object o : array) {
                    if (o instanceof JSONObject) {

                        Movie movie = movieService.parseRequest((JSONObject) o);

                        movie.setPlot(movieService.parsePlots(movieService.getPlot(movie.getId())));

                        movie.setRating(movieService.parseRatings(movieService.getRatings(movie.getId())));

                        logger.info(movie.toString());
                        movieList.put(movie);

                        i++;
                        if (i > limit) {
                            break;
                        }
                    }
                }
            }
            response.put("movie", movieList);
            }
        catch (Exception e){
            response.put("movie",movieList);
        }
        long delay = System.currentTimeMillis() - start;
        logger.info("Backend API Requested Time : {} ms", delay);

        response.put("delay(ms)", delay);
        return response.toMap();
    }

}
