package com.example.ratha.localstorage.entity;

/**
 * Created by ratha on 2/19/2018.
 */

public class LanguageState {
    private String name;
    private String code;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "LanguageState{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
