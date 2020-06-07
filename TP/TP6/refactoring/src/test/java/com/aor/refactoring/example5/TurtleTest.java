package com.aor.refactoring.example5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurtleTest {

    @Test
    public void testRotateLeft() {
        Turtle turtle = new Turtle(5, 5, new TurtleNorth());
        turtle.execute('L'); assertTrue(turtle.getTurtleDirection() instanceof TurtleWest);
        turtle.execute('L'); assertTrue(turtle.getTurtleDirection() instanceof TurtleSouth);
        turtle.execute('L'); assertTrue(turtle.getTurtleDirection() instanceof TurtleEast);
        turtle.execute('L'); assertTrue(turtle.getTurtleDirection() instanceof TurtleNorth);
        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testRotateRight() {
        Turtle turtle = new Turtle(5, 5, new TurtleNorth());
        turtle.execute('R'); assertTrue(turtle.getTurtleDirection() instanceof TurtleEast);
        turtle.execute('R'); assertTrue(turtle.getTurtleDirection() instanceof TurtleSouth);
        turtle.execute('R'); assertTrue(turtle.getTurtleDirection() instanceof TurtleWest);
        turtle.execute('R'); assertTrue(turtle.getTurtleDirection() instanceof TurtleNorth);
        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testForward() {
        Turtle turtleN = new Turtle(5, 5, new TurtleNorth());

        turtleN.execute('F');
        assertEquals(4, turtleN.getRow());
        assertEquals(5, turtleN.getColumn());

        Turtle turtleW = new Turtle(5, 5, new TurtleWest());

        turtleW.execute('F');
        assertEquals(5, turtleW.getRow());
        assertEquals(4, turtleW.getColumn());

        Turtle turtleS = new Turtle(5, 5, new TurtleSouth());

        turtleS.execute('F');
        assertEquals(6, turtleS.getRow());
        assertEquals(5, turtleS.getColumn());

        Turtle turtleE = new Turtle(5, 5, new TurtleEast());

        turtleE.execute('F');
        assertEquals(5, turtleE.getRow());
        assertEquals(6, turtleE.getColumn());
    }

}