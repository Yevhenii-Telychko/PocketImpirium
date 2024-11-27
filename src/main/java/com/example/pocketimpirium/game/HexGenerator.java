package com.example.pocketimpirium.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HexGenerator {
    // hexId have the form {idOfSectoridOfhex}
    private int hexId = 10;

    public HexGenerator() {

    }

    public List<Hex> generateHexes(int numberOfHexes, Sector sector) {
        // List of hexes in one sector
        ArrayList<Hex> hexes = new ArrayList<>();

        // Set to all hexes LEVEL_3 if TriPrime
        if (sector.getIsTriPrime()) {
            // Generation of hexes
            for (int i = hexId; i < hexId + numberOfHexes; i++) {
                hexes.add(new Hex(i, SystemLevel.LEVEL_3, sector));
            }
        } else {
            HashMap<Integer, SystemLevel> systemPlanet = generateSystemPlanet(numberOfHexes);

            // Generation of hexes
            for (int i = hexId; i < hexId + numberOfHexes; i++) {
                hexes.add(new Hex(i, systemPlanet.getOrDefault(i, SystemLevel.LEVEL_0), sector));
            }
        }

        hexId = modifyHexId(sector.getId());
        return hexes;
    }

    // Generate Random ids for the system levels planet
    public List<Integer> generateIdForSysLevel(int numberOfHexes) {
        List<Integer> idOfSystemLevel = new ArrayList<>();

        for (int i = hexId; i < hexId + numberOfHexes; i++) {
            idOfSystemLevel.add(i);
        }

        Collections.shuffle(idOfSystemLevel);
        idOfSystemLevel = idOfSystemLevel.subList(0, 3);

        return idOfSystemLevel;
    }

    public HashMap<Integer, SystemLevel> generateSystemPlanet(int numberOfHexes) {
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

    public int modifyHexId(int sectorId) {
        return 10 * (sectorId + 1);
    }
}
