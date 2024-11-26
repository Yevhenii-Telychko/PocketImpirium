package com.example.pocketimpirium.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    // Class for testing the functionality without UI

    public static void main(String[] args){
        GameMap gameMap = new GameMap();

        List<Sector> sectors = gameMap.generateSectors(7);

        for(Sector sector : sectors){
            System.out.println(sector);
        }


    }

}
