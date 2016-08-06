package com.example.jc.volley.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jc on 14/07/16.
 */
public class Districts {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Districts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
