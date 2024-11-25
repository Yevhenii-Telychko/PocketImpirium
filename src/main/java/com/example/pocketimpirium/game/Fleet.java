package com.example.pocketimpirium.game;

import java.util.List;

public class Fleet {
    private Player owner;
    private List<Ship> ships;
    private Hex currentHex;

    public Fleet(Player owner, List<Ship> ships, Hex currentHex) {
        this.owner = owner;
        this.ships = ships;
        this.currentHex = currentHex;
    }

    public Player getOwner() {
        return owner;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public Hex getCurrentHex() {
        return currentHex;
    }

    public void addShip(Ship ship) {
    }

    public void removeShip(Ship ship) {
    }

    public void move(Hex hex) {
    }

    public void invade(Hex hex) {
    }
}
