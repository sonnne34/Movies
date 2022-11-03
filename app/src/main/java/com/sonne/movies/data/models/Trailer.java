package com.sonne.movies.data.models;

import com.google.gson.annotations.SerializedName;

public class Trailer {

    public Trailer(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
