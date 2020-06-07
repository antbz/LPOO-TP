package com.aor.refactoring.example5;

public class TurtleSouth extends TurtleDirection {
    public TurtleSouth() {
    }

    public TurtleSouth(Turtle turtle) {
        this.setTurtle(turtle);
    }

    @Override
    public void rotateRight() {
        turtle.setTurtleDirection(new TurtleWest(turtle));
    }

    @Override
    public void rotateLeft() {
        turtle.setTurtleDirection(new TurtleEast(turtle));
    }

    @Override
    public void moveForward() {
        turtle.setRow(turtle.getRow() + 1);
    }
}
