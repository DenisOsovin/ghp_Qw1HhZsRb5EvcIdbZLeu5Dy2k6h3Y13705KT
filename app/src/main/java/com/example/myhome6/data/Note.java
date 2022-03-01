package com.example.myhome6.data;

import java.io.Serializable;

//с помощью Serializable можно класть intent
public class Note implements Serializable {

    //создаём ключ
    public static final String Note= "NOTE";

    //создание дочерней активности в рамках дз
    //...

    private Integer id; //идентфиикатор заментки
    private String title; //заголовок-день недели
    private String description; //описание-погода

    //создаём конструктор
    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    //для изменения и получения полей используется
    //POJO Plain Old Java Object
    //генерируем методы и функции


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
