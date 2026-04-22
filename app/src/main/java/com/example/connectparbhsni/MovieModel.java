package com.example.connectparbhsni;

import java.io.Serializable;
import java.util.List;

public class MovieModel implements Serializable {
    private String movieName;
    private String language;
    private List<String> showTimings;
    private String lastUpdated;
    private String poster; // Optional future use

    public MovieModel(String movieName, String language, List<String> showTimings, String lastUpdated) {
        this.movieName = movieName;
        this.language = language;
        this.showTimings = showTimings;
        this.lastUpdated = lastUpdated;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getLanguage() {
        return language;
    }

    public List<String> getShowTimings() {
        return showTimings;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getPoster() {
        return poster;
    }
}
