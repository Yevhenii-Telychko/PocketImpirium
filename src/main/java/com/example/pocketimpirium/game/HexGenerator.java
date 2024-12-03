package com.example.pocketimpirium.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HexGenerator {
    private final CoordinatePlane coordinatePlane;
    // hexId have the form {idOfSectorIdOfHex}
    private int hexId = 10;
    private List<Hex> hexes;

    public HexGenerator(CoordinatePlane coordinatePlane) {
        this.coordinatePlane = coordinatePlane;
    }

    public List<Hex> getHexes() {
        return hexes;
    }

    public void generateHexes(int numberOfHexes, Sector sector) {
        this.hexes = new ArrayList<>();

        // Getting transformed Hexes coor according to the side of the sector
        int[][] transformedHexesCoor = coordinatePlane.getTransformedHexesCoordinates("CENTRAL");
        for (String side : sector.getSideAsList()) {
            transformedHexesCoor = coordinatePlane.getTransformedHexesCoordinates(side, transformedHexesCoor);
        }

        //id for tracking coordinates for particular hex
        int coorId = 0;
        int[] hexCoor = transformedHexesCoor[coorId];

        // Set to all hexes LEVEL_3 if TriPrime
        if (sector.getIsTriPrime()) {
            // Generation of hexes
            for (int i = hexId; i < hexId + numberOfHexes; i++) {
                hexes.add(new Hex(i, hexCoor[0], hexCoor[1], SystemLevel.LEVEL_3, sector));
                coorId++;
            }
        } else {
            //Ids of system level
            HashMap<Integer, SystemLevel> systemPlanet = generateSystemPlanet(numberOfHexes);

            // Generation of hexes
            for (int i = hexId; i < hexId + numberOfHexes; i++) {
                hexes.add(new Hex(i, hexCoor[0], hexCoor[1], systemPlanet.getOrDefault(i, SystemLevel.LEVEL_0), sector));
                coorId++;
            }
        }
        hexId = modifyHexId(sector.getId());
    }

    // Generate Random ids for the system levels planet
    private List<Integer> generateIdForSysLevel(int numberOfHexes) {
        List<Integer> idOfSystemLevel = new ArrayList<>();

        for (int i = hexId; i < hexId + numberOfHexes; i++) {
            idOfSystemLevel.add(i);
        }

        Collections.shuffle(idOfSystemLevel);
        idOfSystemLevel = idOfSystemLevel.subList(0, 3);

        return idOfSystemLevel;
    }

    private HashMap<Integer, SystemLevel> generateSystemPlanet(int numberOfHexes) {
        List<Integer> idOfSystemLevel = generateIdForSysLevel(numberOfHexes);

        // Create a list of levels
        List<SystemLevel> levels = new ArrayList<>();
        levels.add(SystemLevel.LEVEL_1);
        levels.add(SystemLevel.LEVEL_1);
        levels.add(SystemLevel.LEVEL_2);

        Collections.shuffle(levels);

        // Create a dict of system level planets
        HashMap<Integer, SystemLevel> systemLevelsPlanet = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            systemLevelsPlanet.put(idOfSystemLevel.get(i), levels.get(i));
        }

        return systemLevelsPlanet;
    }

    private int modifyHexId(int sectorId) {
        return 10 * (sectorId + 1);
    }
}
