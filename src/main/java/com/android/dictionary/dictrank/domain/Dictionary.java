package com.android.dictionary.dictrank.domain;

public class Dictionary {

    private final long id;
    private final String name;
    private String provider;
    private double rating;
    private String price;
    private String fromLanguauge;
    private String toLanguage;

    public Dictionary(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dictionary(long id, String name, String provider, double rating, String price, String fromLanguauge, String toLanguage) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.provider = provider;
        this.price = price;
        this.fromLanguauge = fromLanguauge;
        this.toLanguage = toLanguage;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFromLanguauge() {
        return fromLanguauge;
    }

    public void setFromLanguauge(String fromLanguauge) {
        this.fromLanguauge = fromLanguauge;
    }

    public String getToLanguage() {
        return toLanguage;
    }

    public void setToLanguage(String toLanguage) {
        this.toLanguage = toLanguage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
