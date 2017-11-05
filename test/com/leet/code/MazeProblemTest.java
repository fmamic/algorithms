package com.leet.code;

import org.junit.Test;

public class MazeProblemTest {

    @Test
    public void knightsTourTest() {
        final MazeProblem mazeProblem = new MazeProblem();

        int[][] maze = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        System.out.println(mazeProblem.mazeSolution(maze));
    }

}
