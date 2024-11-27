package com.example.pocketimpirium.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    // Class for testing the functionality without UI

    public static void main(String[] args){
        GameMap gameMap = new GameMap(7);
        gameMap.initialize();

        List<Sector> sectors = gameMap.getSectors();
//        Map<Hex, List<Hex>> hexesGraph = gameMap.getHexesGraph();

        for(Sector sector : sectors){
            System.out.println(sector);
        }

//        for(Hex node: hexesGraph.keySet()){
//            System.out.print(node.getId() + ": ");
//            for(Hex neighbor: hexesGraph.get(node)){
//                System.out.print(neighbor.getId() + ", ");
//            }
//            System.out.println();
//        }

    }

}
