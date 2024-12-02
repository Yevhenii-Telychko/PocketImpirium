package com.example.pocketimpirium.game;

import java.util.*;

public class Main {
    // Class for testing the functionality without UI

    public static void main(String[] args){

        List<List<String>> configuration = Arrays.asList(
                List.of("CENTRAL"),
                List.of("NE", "NE"),
                List.of("E", "SE"),
                List.of("SE"),
                List.of("SW"),
                List.of("W"),
                List.of("NW")
        );
        GameMap gameMap = new GameMap(configuration);
        gameMap.initialize();

        List<Sector> sectors = gameMap.getSectors();
//        Map<Hex, List<Hex>> hexesGraph = gameMap.getHexesGraph();

        for(Sector sector : sectors){
            System.out.println(sector);
        }
//
//        String side = "NE ";
//        System.out.println(Arrays.toString(side.split(" ")));
//        for(Hex node: hexesGraph.keySet()){
//            System.out.print(node.getId() + ": ");
//            for(Hex neighbor: hexesGraph.get(node)){
//                System.out.print(neighbor.getId() + ", ");
//            }
//            System.out.println();
//        }

    }

}
