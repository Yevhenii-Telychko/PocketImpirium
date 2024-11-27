package com.example.pocketimpirium.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HexesGraph {
    public List<Sector> sectors;
    private final Map<Hex, List<Hex>> hexesGraph = new HashMap<>();

    public HexesGraph(List<Sector> sectors) {
        this.sectors = sectors;
    }

    public void addNode(Hex node) {
        hexesGraph.put(node, new ArrayList<Hex>());
    }

    public void addNeighbor(Hex node, Hex neighbor) {
        hexesGraph.get(node).add(neighbor);
        hexesGraph.get(neighbor).add(node);
    }

    // Link all the hexes in one sector
    public void linkHexesInSector() {
        for (Sector sector : sectors) {
            List<Hex> hexes = sector.getHexes();
            for (Hex hex : hexes) {
                addNode(hex);
            }
            addNeighbor(hexes.get(0), hexes.get(1));
            addNeighbor(hexes.get(0), hexes.get(5));
            addNeighbor(hexes.get(0), hexes.get(6));
            addNeighbor(hexes.get(1), hexes.get(2));
            addNeighbor(hexes.get(1), hexes.get(6));
            addNeighbor(hexes.get(2), hexes.get(3));
            addNeighbor(hexes.get(2), hexes.get(6));
            addNeighbor(hexes.get(3), hexes.get(4));
            addNeighbor(hexes.get(3), hexes.get(6));
            addNeighbor(hexes.get(4), hexes.get(5));
            addNeighbor(hexes.get(4), hexes.get(6));
            addNeighbor(hexes.get(5), hexes.get(6));
        }
    }

    public Hex getHexByIdAndSector(int id, Sector sector) {
        return sectors.get(sectors.indexOf(sector)).getHexes().get(id);
    }

    public void linkHexesOnBoarder() {
        // all the hexes with TriPrime
        addNeighbor(getHexByIdAndSector(3, sectors.get(0)), getHexByIdAndSector(1, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(4, sectors.get(0)), getHexByIdAndSector(0, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(4, sectors.get(1)), getHexByIdAndSector(2, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(4, sectors.get(0)), getHexByIdAndSector(1, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(5, sectors.get(1)), getHexByIdAndSector(1, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(5, sectors.get(1)), getHexByIdAndSector(2, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(0, sectors.get(2)), getHexByIdAndSector(2, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(0, sectors.get(2)), getHexByIdAndSector(3, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(5, sectors.get(2)), getHexByIdAndSector(3, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(0, sectors.get(3)), getHexByIdAndSector(4, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(1, sectors.get(3)), getHexByIdAndSector(3, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(1, sectors.get(3)), getHexByIdAndSector(4, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(1, sectors.get(4)), getHexByIdAndSector(5, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(2, sectors.get(4)), getHexByIdAndSector(4, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(2, sectors.get(4)), getHexByIdAndSector(5, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(2, sectors.get(5)), getHexByIdAndSector(0, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(3, sectors.get(5)), getHexByIdAndSector(0, sectors.get(6)));
        addNeighbor(getHexByIdAndSector(3, sectors.get(5)), getHexByIdAndSector(5, sectors.get(6)));

        //hexes between the border's hexes
        addNeighbor(getHexByIdAndSector(2, sectors.get(0)), getHexByIdAndSector(0, sectors.get(1)));
        addNeighbor(getHexByIdAndSector(3, sectors.get(0)), getHexByIdAndSector(0, sectors.get(1)));
        addNeighbor(getHexByIdAndSector(3, sectors.get(0)), getHexByIdAndSector(5, sectors.get(1)));
        addNeighbor(getHexByIdAndSector(3, sectors.get(1)), getHexByIdAndSector(1, sectors.get(2)));
        addNeighbor(getHexByIdAndSector(4, sectors.get(1)), getHexByIdAndSector(0, sectors.get(2)));
        addNeighbor(getHexByIdAndSector(4, sectors.get(1)), getHexByIdAndSector(1, sectors.get(2)));
        addNeighbor(getHexByIdAndSector(4, sectors.get(2)), getHexByIdAndSector(2, sectors.get(3)));
        addNeighbor(getHexByIdAndSector(5, sectors.get(2)), getHexByIdAndSector(1, sectors.get(3)));
        addNeighbor(getHexByIdAndSector(5, sectors.get(2)), getHexByIdAndSector(2, sectors.get(3)));
        addNeighbor(getHexByIdAndSector(0, sectors.get(3)), getHexByIdAndSector(2, sectors.get(4)));
        addNeighbor(getHexByIdAndSector(0, sectors.get(3)), getHexByIdAndSector(3, sectors.get(4)));
        addNeighbor(getHexByIdAndSector(5, sectors.get(3)), getHexByIdAndSector(3, sectors.get(4)));
        addNeighbor(getHexByIdAndSector(0, sectors.get(4)), getHexByIdAndSector(4, sectors.get(5)));
        addNeighbor(getHexByIdAndSector(1, sectors.get(4)), getHexByIdAndSector(3, sectors.get(5)));
        addNeighbor(getHexByIdAndSector(1, sectors.get(4)), getHexByIdAndSector(4, sectors.get(5)));
        addNeighbor(getHexByIdAndSector(1, sectors.get(5)), getHexByIdAndSector(5, sectors.get(0)));
        addNeighbor(getHexByIdAndSector(2, sectors.get(5)), getHexByIdAndSector(4, sectors.get(0)));
        addNeighbor(getHexByIdAndSector(2, sectors.get(5)), getHexByIdAndSector(5, sectors.get(0)));

    }


    public void initialize() {
        this.linkHexesInSector();
        this.linkHexesOnBoarder();
    }

    public Map<Hex, List<Hex>> getHexesGraph() {
        return hexesGraph;
    }

}
