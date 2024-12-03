package com.example.pocketimpirium.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HexesGraph {
    private final Map<Hex, List<Hex>> hexesGraph = new HashMap<>();

    private final int[][] directions = {
            {0, -1},
            {1, -1},
            {1, 0},
            {0, 1},
            {-1, 1},
            {-1, 0}
    };

    public HexesGraph(List<Sector> sectors) {
        linkHexes(sectors);
    }

    private void linkHexes(List<Sector> sectors) {
        List<Hex> allHexes = new ArrayList<>();
        // Collect all hexes from all sectors
        for (Sector sector : sectors) {
            allHexes.addAll(sector.getHexes());
        }

        // Create an adjacency list for hex neighbors
        for (Hex hex : allHexes) {
            List<Hex> neighbors = findNeighbors(hex, allHexes);
            hexesGraph.put(hex, neighbors);
        }
    }

    private List<Hex> findNeighbors(Hex hex, List<Hex> allHexes) {
        List<Hex> neighbors = new ArrayList<>();
        for (Hex candidate : allHexes) {
            if (isNeighbor(hex, candidate)) {
                neighbors.add(candidate);
            }
        }
        return neighbors;
    }

    private boolean isNeighbor(Hex h1, Hex h2) {
        for (int[] direction : directions) {
            int x = h1.getX() + direction[0];
            int y = h1.getY() + direction[1];
            if(x == h2.getX() && y == h2.getY()) {
                return true;
            }
        }
        return false;
    }

    public Map<Hex, List<Hex>> getHexesGraph() {
        return hexesGraph;
    }
}
