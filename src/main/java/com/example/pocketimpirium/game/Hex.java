package com.example.pocketimpirium.game;

import java.util.List;

public class Hex {
    private final int id;
    private final SystemLevel systemLevel;
    private Sector sector;
    private List<Fleet> fleets;

    public Hex(int id, SystemLevel systemLevel, Sector sector) {
        this.id = id;
        this.systemLevel = systemLevel;
        this.sector = sector;
    }

    public int getId() {
        return id;
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

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public void addFleet(Fleet fleet) {
    }

    public void removerFleet(Fleet fleet) {
    }

    public boolean isControlledByPlayer(Player player) {
        return false;
    }

    public String toString() {
        return "ID: " + id + " System Level: " + systemLevel;
    }
}
