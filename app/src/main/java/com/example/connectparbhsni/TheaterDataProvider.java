package com.example.connectparbhsni;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TheaterDataProvider {

    private static List<TheaterModel> cachedTheaters;
    private static Map<String, List<MovieModel>> cachedMovies;

    public static List<TheaterModel> getAllTheaters() {
        if (cachedTheaters != null) return cachedTheaters;

        cachedTheaters = new ArrayList<>();
        cachedTheaters.add(new TheaterModel(
            "Anusaya E-Square", 
            "Jalna - Nanded Rd, Parbhani", 
            19.2685, 
            76.7750, 
            "02452225555", 
            "Multiplex",
            "Premium multiplex experience with state-of-the-art projection and sound.",
            R.drawable.ic_theater,
            true
        ));
        cachedTheaters.add(new TheaterModel(
            "Naresh Cineplex", 
            "Station Road, Parbhani", 
            19.2630, 
            76.7840, 
            "02452221122", 
            "Multiplex",
            "Popular cineplex known for latest Bollywood and Marathi releases.",
            R.drawable.ic_theater,
            true
        ));
        cachedTheaters.add(new TheaterModel(
            "Mahavir Cinema Hall", 
            "Gandhi Park, Parbhani", 
            19.2710, 
            76.7720, 
            "02452223344", 
            "Single Screen",
            "Heritage single-screen cinema offering a classic movie-watching experience.",
            R.drawable.ic_theater,
            false
        ));
        cachedTheaters.add(new TheaterModel(
            "Shivram Theatre", 
            "Basmat Road, Parbhani", 
            19.2620, 76.7790, 
            "02452228899", 
            "Single Screen",
            "Well-maintained theatre featuring local and regional cinema.",
            R.drawable.ic_theater,
            false
        ));
        cachedTheaters.add(new TheaterModel(
            "Talreja Cinema", 
            "Old City Area, Parbhani", 
            19.2750, 
            76.7680, 
            "02452227788", 
            "Single Screen",
            "One of the oldest cinemas in Parbhani, still popular among locals.",
            R.drawable.ic_theater,
            false
        ));
        return cachedTheaters;
    }

    public static Map<String, List<MovieModel>> getMoviesByTheater(Context context) {
        if (cachedMovies != null) return cachedMovies;

        cachedMovies = new HashMap<>();
        String json = loadJSONFromAsset(context, "movies_data.json");

        if (json == null) {
            return cachedMovies;
        }

        try {
            JSONObject root = new JSONObject(json);
            Iterator<String> theaterNames = root.keys();

            while (theaterNames.hasNext()) {
                String theaterName = theaterNames.next();
                JSONArray moviesArray = root.getJSONArray(theaterName);
                List<MovieModel> movies = new ArrayList<>();

                for (int i = 0; i < moviesArray.length(); i++) {
                    JSONObject movieObject = moviesArray.getJSONObject(i);
                    String movieName = movieObject.getString("movieName");
                    String language = movieObject.getString("language");
                    JSONArray timingsArray = movieObject.getJSONArray("showTimings");

                    List<String> showTimings = new ArrayList<>();
                    for (int j = 0; j < timingsArray.length(); j++) {
                        showTimings.add(timingsArray.getString(j));
                    }
                    
                    movies.add(new MovieModel(movieName, language, showTimings, "Updated Today"));
                }
                cachedMovies.put(theaterName, movies);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cachedMovies;
    }

    private static String loadJSONFromAsset(Context context, String fileName) {
        String json;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
