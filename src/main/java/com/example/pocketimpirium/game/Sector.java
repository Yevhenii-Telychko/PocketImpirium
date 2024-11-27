package com.example.pocketimpirium.game;

import java.util.List;
import java.util.Objects;

public class Sector {
    private final int id;
    private final List<Hex> hexes;
    private final boolean isTriPrime;
    private final String side;
    private boolean isScored;


    public Sector(int id, List<Hex> hexes, String side) {
        this.id = id;
        this.hexes = hexes;
        this.isTriPrime = Objects.equals(side, "CENTRAL");
        this.side = side;
        resetIsScored();
    }

    public int getId() {
        return id;
    }

    public String getSide() {
        return side;
    }

    public List<Hex> getHexes() {
        return hexes;
    }

    public boolean getIsTriPrime() {
        return isTriPrime;
    }

    public boolean getIsScored() {
        return isScored;
    }

    private void resetIsScored() {
        isScored = false;
    }

    public void planCommands() {
    }

    public void performCommands() {
    }

    public Sector chooseSectorToScore() {
        return null;
    }

    public String toString() {
        StringBuilder hexesString = new StringBuilder();
        for (Hex hex : hexes) {
            hexesString.append("\n  ").append(hex);
        }
        return "Sector " + id + " Side: " + side + "\nHexes:[" + hexesString + "\n]" + "\nTriprime: " + isTriPrime;
    }

}
