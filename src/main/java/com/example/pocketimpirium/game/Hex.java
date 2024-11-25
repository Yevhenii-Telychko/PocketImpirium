package com.example.pocketimpirium.game;

import java.util.ArrayList;
import java.util.List;

public class Hex {
    private int x;
    private int y;
    private SystemLevel systemLevel;
    private Sector sector;
    private List<Fleet> fleets;

    public Hex(int x, int y, SystemLevel systemLevel, Sector sector, List<Fleet> fleets) {
        this.x = x;
        this.y = y;
        this.systemLevel = systemLevel;
        this.sector = sector;
        this.fleets = fleets != null ? fleets : new ArrayList<Fleet>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public SystemLevel getSystemLevel() {
        return systemLevel;
    }

    public Sector getSector() {
        return sector;
    }

    public List<Fleet> getFleets() {
        return fleets;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addFleet(Fleet fleet) {
    }

    public void removerFleet(Fleet fleet) {
    }

    public boolean isControlledByPlayer(Player player) {
        return false;
    }
}
