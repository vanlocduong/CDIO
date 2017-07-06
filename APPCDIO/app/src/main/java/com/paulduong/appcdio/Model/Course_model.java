package com.paulduong.appcdio.Model;

/**
 * Created by PaulDuong on 7/4/2017.
 */

public class Course_model {
    public  Course_model(String name, String description)
    {
        this.name= name;
        this.description= description;
    }
    String name;

    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
