package com.example.pocketimpirium.game;

import javafx.scene.layout.Priority;

public abstract class Command {
    protected Priority priority;

    public Command(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    public abstract void execute(Player player);
}
