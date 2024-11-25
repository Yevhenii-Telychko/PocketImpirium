package com.example.pocketimpirium.game;


import java.util.List;

public class Player {
    private String name;
    private int score;
    private List<Ship> ships;
    private List<Fleet> fleets;
    private List<Command> commands;
    private Color color;

    public void Player(String name, int score, List<Ship> ships, List<Fleet> fleets, List<Command> commands, Color color) {
        this.name = name;
        this.score = score;
        this.ships = ships;
        this.fleets = fleets;
        this.commands = commands;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Fleet> getFleets() {
        return fleets;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Color getColor() {
        return color;
    }

    public void planCommands() {
    }

    public void performCommands() {
    }

    public Sector chooseSectorToScore() {
        return null;
    }

    public void sustainShips() {
    }

    public void addPoint() {
    }

    public void initialDeployment() {
    }
}
