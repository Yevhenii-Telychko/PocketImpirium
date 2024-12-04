package com.example.pocketimpirium.game;

import java.util.*;

public class HexesGraph {
    private final Map<Hex, List<Hex>> hexesGraph = new HashMap<>();

    private final int[][] directions = {
            {0, -1}, // TOP
            {1, -1}, // TOP-RIGHT
            {1, 0}, // BOTTOM-RIGHT
            {0, 1}, // BOTTOM
            {-1, 1}, // BOTTOM-LEFT
            {-1, 0} // TOP-LEFT
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
            if (x == h2.getX() && y == h2.getY()) {
                return true;
            }
        }
        return false;
    }

    public int getMoveCount(Hex start, Hex target) {
        // If we are already at target
        if (start.equals(target)) {
            return 0;
        }

        Queue<Hex> queue = new LinkedList<>();
        Set<Hex> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        int moves = 0;

        // BFS
        while (!queue.isEmpty() && moves < 3) {
            int size = queue.size();
            moves++;

            for (int i = 0; i < size; i++) {
                Hex current = queue.poll();

                for (Hex neighbour : hexesGraph.getOrDefault(current, Collections.emptyList())) {
                    if (neighbour.equals(target)) {
                        return moves;
                    }

                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }

        }
        return -1;
    }

    public Map<Hex, List<Hex>> getHexesGraph() {
        return hexesGraph;
    }
}
