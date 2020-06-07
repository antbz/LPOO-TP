package com.aor.refactoring.example5;

public class TurtleNorth extends TurtleDirection {
    public TurtleNorth() {
    }

    public TurtleNorth(Turtle turtle) {
        this.setTurtle(turtle);
    }

    @Override
    public void rotateRight() {
        turtle.setTurtleDirection(new TurtleEast(turtle));
    }

    @Override
    public void rotateLeft() {
        turtle.setTurtleDirection(new TurtleWest(turtle));
    }

    @Override
    public void moveForward() {
        turtle.setRow(turtle.getRow() - 1);
    }
}
