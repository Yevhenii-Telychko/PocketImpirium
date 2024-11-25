package com.example.pocketimpirium.game;

public enum SystemLevel {
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3);

    private final int levelId;

    SystemLevel(int levelId) {
        this.levelId = levelId;
    }

    public int getLevelId() {
        return levelId;
    }
}
