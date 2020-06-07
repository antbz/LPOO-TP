package com.aor.refactoring.example5;

public class TurtleWest extends TurtleDirection {
    public TurtleWest() {
    }

    public TurtleWest(Turtle turtle) {
        this.setTurtle(turtle);
    }

    @Override
    public void rotateRight() {
        turtle.setTurtleDirection(new TurtleNorth(turtle));
    }

    @Override
    public void rotateLeft() {
        turtle.setTurtleDirection(new TurtleSouth(turtle));
    }

    @Override
    public void moveForward() {
        turtle.setColumn(turtle.getColumn() - 1);
    }
}
