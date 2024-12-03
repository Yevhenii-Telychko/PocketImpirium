package com.example.pocketimpirium.game;

import java.util.*;

public class Main {
    // Class for testing the functionality without UI

    public static void main(String[] args){

        List<List<String>> configuration = Arrays.asList(
                List.of("CENTRAL"),
                List.of("NE"),
                List.of("E"),
                List.of("SE"),
                List.of("SW"),
                List.of("W"),
                List.of("NW")
        );
        GameMap gameMap = new GameMap(configuration);
        gameMap.initialize();

        List<Sector> sectors = gameMap.getSectors();
        Map<Hex, List<Hex>> hexesGraph = gameMap.getGraph().getHexesGraph();

//        for(Sector sector : sectors){
//            System.out.println(sector);
//        }

//        for(Hex hex : hexesGraph.keySet()){
//            System.out.println(hex + ":" + hexesGraph.get(hex));
//        }

        Hex hex1 = sectors.getFirst().getHexes().getFirst();
        Hex hex2 = sectors.get(1).getHexes().get(1);
        System.out.println(hex1);
        System.out.println(hex2);
        int moves = gameMap.getGraph().getMoveCount(hex1, hex2);
        System.out.println(moves);

    }

}
