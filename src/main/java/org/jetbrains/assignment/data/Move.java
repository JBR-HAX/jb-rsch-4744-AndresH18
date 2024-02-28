package org.jetbrains.assignment.data;

public class Move {
    public enum Direction {
        NORTH,
        WEST,
        SOUTH,
        EAST
    }

    private Direction direction;
    private int value;

    public Move(Direction direction, int value) {
        this.direction = direction;
        this.value = Math.abs(value);
    }

    public Move() {
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
