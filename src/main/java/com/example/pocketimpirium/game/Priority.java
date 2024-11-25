package com.example.pocketimpirium.game;

public enum Priority {
    PRIORITY_1(1),
    PRIORITY_2(2),
    PRIORITY_3(3);
    private final int priority;

    Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
