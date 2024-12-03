package com.example.pocketimpirium.game;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CoordinatePlane {
    //Initial coor of hexes in the central sector
    private final int[][] basisHexesCoordinates = {
            {0, 0}, {0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1, 1}, {-1, 0}
    };

    private final Map<String, Function<int[], int[]>> transformationFunctions = new HashMap<>();

    public CoordinatePlane() {
        this.setTransformationFunctions();
    }

    private void setTransformationFunctions() {
        Function<int[], int[]> CENTRAL = (vector) -> vector;
        Function<int[], int[]> NE = (vector) -> new int[]{vector[0] + 2, vector[1] - 3};
        Function<int[], int[]> E = (vector) -> new int[]{vector[0] + 3, vector[1] - 1};
        Function<int[], int[]> SE = (vector) -> new int[]{vector[0] + 1, vector[1] + 2};
        Function<int[], int[]> SW = (vector) -> new int[]{vector[0] - 2, vector[1] + 3};
        Function<int[], int[]> W = (vector) -> new int[]{vector[0] - 3, vector[1] + 1};
        Function<int[], int[]> NW = (vector) -> new int[]{vector[0] - 1, vector[1] - 2};

        this.transformationFunctions.put("CENTRAL", CENTRAL);
        this.transformationFunctions.put("NE", NE);
        this.transformationFunctions.put("E", E);
        this.transformationFunctions.put("SE", SE);
        this.transformationFunctions.put("SW", SW);
        this.transformationFunctions.put("W", W);
        this.transformationFunctions.put("NW", NW);
    }

    // Transforming the hexes according to the side
    private int[][] transformHexesCoorInSector(String side, int[][]hexesCoordinates){
        Function<int[], int[]> transformationFunction = this.transformationFunctions.get(side);
        int[][] transformedHexesCoor = new int[hexesCoordinates.length][hexesCoordinates[0].length];
        for (int i = 0; i < hexesCoordinates.length; i++) {
            transformedHexesCoor[i] = transformationFunction.apply(hexesCoordinates[i]);
        }
        return transformedHexesCoor;
    }

    public int[][] getTransformedHexesCoordinates(String side){
        return transformHexesCoorInSector(side, this.basisHexesCoordinates);
    }
    public int[][] getTransformedHexesCoordinates(String side, int[][]hexesCoordinates) {
        return transformHexesCoorInSector(side, hexesCoordinates);
    }
}
