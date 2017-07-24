package com.go.jinglesample.model;

import java.util.List;

public final class User implements Cloneable {
    public List<Photo> photos;

    public String first_name;
    public int age;

    public String job;
    public String company;

    public int percent;

    public String whatIfWe;

    public String city;
    private transient String capitalizedCity;

    public String getCapitalizedCity() {
        if (capitalizedCity == null) {
            StringBuilder sb = new StringBuilder(city);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            capitalizedCity = sb.toString();
        }
        return capitalizedCity;
    }

    public static User clone(final User from) {
        try {
            return (User) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
