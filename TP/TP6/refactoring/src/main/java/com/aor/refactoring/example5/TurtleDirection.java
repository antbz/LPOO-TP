package com.aor.refactoring.example5;

public abstract class TurtleDirection {
    protected Turtle turtle;

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    public abstract void rotateRight();
    public abstract void rotateLeft();
    public abstract void moveForward();
}
