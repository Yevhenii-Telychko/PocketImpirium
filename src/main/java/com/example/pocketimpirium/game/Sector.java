package com.example.pocketimpirium.game;

import java.util.List;

public class Sector {
    private final int id;
    private final List<Hex> hexes;
    private final boolean isTriPrime;
    private boolean isScored;

    public Sector(int id, List<Hex> hexes, boolean isTriPrime) {
        this.id = id;
        this.hexes = hexes;
        this.isTriPrime = isTriPrime;
        resetIsScored();
    }

    public int getId() {
        return id;
    }

    public List<Hex> getHexes() {
        return hexes;
    }

    public boolean getIsTriPrime() {
        return isTriPrime;
    }

    private boolean getIsScored() {
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
        return "Sector " + id + "\nHexes:["+hexesString+"\n]" + "\nTriprime: " + isTriPrime;
    }

}
