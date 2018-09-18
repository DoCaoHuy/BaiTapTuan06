package com.example.student.baitaptuan06;

import java.io.Serializable;

/**
 * Created by Student on 9/18/2018.
 */

public class Person implements Serializable {
    private String id;
    private String name;
    private int age;
    private int img;

    public Person() {
    }

    public Person(String id, String name, int age, int img) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
