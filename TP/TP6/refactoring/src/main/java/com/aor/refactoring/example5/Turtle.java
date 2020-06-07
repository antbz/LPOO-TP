package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private TurtleDirection turtleDirection;

    public Turtle(int row, int column, TurtleDirection turtleDirection) {
        this.row = row;
        this.column = column;
        this.turtleDirection = turtleDirection;
        turtleDirection.setTurtle(this);
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setTurtleDirection(TurtleDirection turtleDirection) {
        this.turtleDirection = turtleDirection;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public TurtleDirection getTurtleDirection() {
        return turtleDirection;
    }

    public void execute(char command) {
        if (command == 'L') { // ROTATE LEFT
            turtleDirection.rotateLeft();
        } else if (command == 'R') { // ROTATE RIGHT
            turtleDirection.rotateRight();
        } else if (command == 'F'){ // MOVE FORWARD
            turtleDirection.moveForward();
        }
    }
}
