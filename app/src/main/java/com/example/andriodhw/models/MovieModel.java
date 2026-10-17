package com.example.andriodhw.models;

public class MovieModel {
    private final double rating;
    private final String type;
    private final String title;
    private final int year;
    private final int duration;
    private final String ageRating;
    private final String genre;
    private final int imageResId;

    public MovieModel(double rating, String type, String title, int year,
                      int duration, String ageRating, String genre, int imageResId) {
        this.rating = rating;
        this.type = type;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.ageRating = ageRating;
        this.genre = genre;
        this.imageResId = imageResId;
    }

    public double getRating() {
        return rating;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public int getImageResId() {
        return imageResId;
    }
}