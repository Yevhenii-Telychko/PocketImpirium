package com.example.pocketimpirium.game;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CoordinatePlane {
    //Initial coor of hexes in the central sector
    private final int[][] basisHexesCoordinates = {
            {0, 0}, {0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1, 1}, {-1, 0}
    };

    private final Map<String, Function<int[], int[]>> tranformationFunctions = new HashMap<>();

    public CoordinatePlane() {
        this.setTranformationFunctions();
    }

    public void setTranformationFunctions() {
        Function<int[], int[]> CENTRAL = (vector) -> vector;
        Function<int[], int[]> NE = (vector) -> new int[]{vector[0] + 2, vector[1] - 3};
        Function<int[], int[]> E = (vector) -> new int[]{vector[0] + 3, vector[1] - 1};
        Function<int[], int[]> SE = (vector) -> new int[]{vector[0] + 1, vector[1] + 2};
        Function<int[], int[]> SW = (vector) -> new int[]{vector[0] - 2, vector[1] + 3};
        Function<int[], int[]> W = (vector) -> new int[]{vector[0] - 3, vector[1] + 1};
        Function<int[], int[]> NW = (vector) -> new int[]{vector[0] - 1, vector[1] - 2};

        this.tranformationFunctions.put("CENTRAL", CENTRAL);
        this.tranformationFunctions.put("NE", NE);
        this.tranformationFunctions.put("E", E);
        this.tranformationFunctions.put("SE", SE);
        this.tranformationFunctions.put("SW", SW);
        this.tranformationFunctions.put("W", W);
        this.tranformationFunctions.put("NW", NW);
    }


    public int[][] transformHexesCoorInSector(String side) {
        Function<int[], int[]> transformationFunction = this.tranformationFunctions.get(side);
        int[][] transformedHexesCoor = new int[basisHexesCoordinates.length][basisHexesCoordinates[0].length];
        for (int i = 0; i < basisHexesCoordinates.length; i++) {
            transformedHexesCoor[i] = transformationFunction.apply(basisHexesCoordinates[i]);
        }
        return transformedHexesCoor;
    }
}
