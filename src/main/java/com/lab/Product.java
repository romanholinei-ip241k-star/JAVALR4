package com.lab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private int id;
    private String name;

    public Product() {} // Порожній конструктор потрібен для Jackson

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public int getId() { return id; }

    @JsonProperty
    public String getName() { return name; }
}
