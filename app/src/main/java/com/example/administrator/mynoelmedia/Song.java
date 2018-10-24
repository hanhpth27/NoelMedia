package com.example.administrator.mynoelmedia;

public class Song {
    private int id;
    private String name;
    private String path;
    private long duration;

    public Song() {
    }

    public Song(int id, String name, String path, long duration) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.duration = duration;
    }

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
