package com.example.pocketimpirium.game;

import java.util.List;

public class Game {
    private List<Player> players;
    private List<Sector> sectors;
    private Player startPlayer;
    private Player currentPlayer;
    private int currentRound;

    public Game(List<Player> players, List<Sector> sectors, Player startPlayer, Player currentPlayer, int currentRound) {
        this.players = players;
        this.sectors = sectors;
        this.startPlayer = startPlayer;
        this.currentPlayer = currentPlayer;
        this.currentRound = currentRound;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public List<Sector> getSectors() {
        return sectors;
    }

    public Player getStartPlayer() {
        return startPlayer;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public int getCurrentRound() {
        return currentRound;
    }

    public void setStartPlayer(Player startPlayer) {
        this.startPlayer = startPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public void initGame(){}
    public void endGame(){}
    public void saveGame(){}
    public void loadGame(){}
    public void nextRound(){}
}
