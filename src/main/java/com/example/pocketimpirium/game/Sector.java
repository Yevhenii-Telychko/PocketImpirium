package com.example.pocketimpirium.game;

import java.util.List;

public class Sector {
    private int level;
    private List<Hex> hexes;
    private boolean isTriprime;
    private boolean isScored;

    public Sector(int level, List<Hex> hexes, boolean isTriprime, boolean isScored) {
        this.level = level;
        this.hexes = hexes;
        this.isTriprime = isTriprime;
        this.isScored = isScored;
    }

    public int getLevel() {
        return level;
    }

    public List<Hex> getHexes() {
        return hexes;
    }

    private boolean getIsTriprime() {
        return isTriprime;
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

}
