package com.android.dictionary.dictrank.domain;

public class Language {

    private long id;
    private String name;

    public Language(String name) {
        this.name = name;
    }

    public Language(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
