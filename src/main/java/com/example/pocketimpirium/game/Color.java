package com.example.pocketimpirium.game;

public enum Color {
    RED("Red"),
    BLUE("Blue"),
    ORANGE("Orange"),
    GREEN("Green");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }


}
