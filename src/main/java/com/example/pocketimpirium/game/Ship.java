package com.example.pocketimpirium.game;

public class Ship {
    private Player owner;

    public Ship(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public void detroy() {
    }
}
