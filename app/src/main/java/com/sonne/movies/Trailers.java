package com.sonne.movies;

import com.google.gson.annotations.SerializedName;

public class Trailers {

    public Trailers(int id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    @SerializedName("id")
    private int id;
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
