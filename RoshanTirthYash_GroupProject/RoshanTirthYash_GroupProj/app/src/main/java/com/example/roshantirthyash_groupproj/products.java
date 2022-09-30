package com.example.roshantirthyash_groupproj;


public class products {
    private String wine_name;
    private Integer wine_image;
    private int wine_price;
    private float wine_star;
    private String wine_description[];
    private int wine_quantity;
    private String wine_regions;
    private String wine_volume;
    private String wine_sweetness;
    private String wine_color;
    private int wine_year;

    public String getWine_name() {
        return wine_name;
    }

    public void setWine_name(String name) {
        this.wine_name = name;
    }

    public Integer getWine_image() {
        return wine_image;
    }

    public void setWine_image(Integer image) {
        this.wine_image = image;
    }

    public int getWine_price() {
        return wine_price;
    }

    public void setWine_price(int price) {
        this.wine_price = price;
    }

    public float getWine_star() {
        return wine_star;
    }

    public void setWine_star(float star) {
        this.wine_star = star;
    }

    public String[] getWine_description() {
        return wine_description;
    }

    public void setWine_description(String description[]) { wine_description = description; }

    public int getWine_quantity() {
        return wine_quantity;
    }

    public void setWine_quantity(int quantity) {
        this.wine_quantity = quantity;
    }

    public String getWine_regions() {
        return wine_regions;
    }

    public void setWine_regions(String regions) {
        this.wine_regions = regions;
    }

    public String getWine_volume() {
        return wine_volume;
    }

    public void setWine_volume(String volume) {
        this.wine_volume = volume;
    }

    public String getWine_sweetness() {
        return wine_sweetness;
    }

    public void setWine_sweetness(String sweetness) {
        this.wine_sweetness = sweetness;
    }

    public String getWine_color() {
        return wine_color;
    }

    public void setWine_color(String color) {
        this.wine_color = color;
    }

    public int getWine_year() {
        return wine_year;
    }

    public void setWine_year(int year) {
        this.wine_year = year;
    }
}