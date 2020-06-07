package com.aor.refactoring.example5;

public class TurtleEast extends TurtleDirection {
    public TurtleEast() {
    }

    public TurtleEast(Turtle turtle) {
        this.setTurtle(turtle);
    }

    @Override
    public void rotateRight() {
        turtle.setTurtleDirection(new TurtleSouth(turtle));
    }

    @Override
    public void rotateLeft() {
        turtle.setTurtleDirection(new TurtleNorth(turtle));
    }

    @Override
    public void moveForward() {
        turtle.setColumn(turtle.getColumn() + 1);
    }
}
