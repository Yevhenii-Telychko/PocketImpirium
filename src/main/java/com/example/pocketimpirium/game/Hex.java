package com.example.pocketimpirium.game;

import java.util.*;

public class Hex {
    private final int id;
    private final SystemLevel systemLevel;
    private final int x;
    private final int y;
    private String type;
    private final Sector sector;
    private List<Fleet> fleets;

    public Hex(int id, int x, int y, SystemLevel systemLevel, Sector sector) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.type = x == 0 && y == 0 ? "Central" : "Side";
        this.systemLevel = systemLevel;
        this.sector = sector;
    }

    public int getId() {
        return id;
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

    public void setType(String type) {this.type = type;}

    public void addFleet(Fleet fleet) {
    }

    public void removerFleet(Fleet fleet) {
    }

    public boolean isControlledByPlayer(Player player) {
        return false;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
//        return "ID: " + id;
        return  id + ":{ \"x\": " + x + ", \"y\": " + y +"},";
    }
}
