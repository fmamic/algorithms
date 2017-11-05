package com.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e.,
 * maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from
 * source and has to reach destination. The rat can move only in two directions: forward and down.
 */
public class MazeProblem {

    public String mazeSolution(int[][] maze) {
        List<String> path = new ArrayList<>();
        mazeSolutionRec(maze, 0, 0, path);

        StringBuilder result = new StringBuilder();
        for (String str : path) {
            result.append(str);
            result.append(" ");
        }
        return result.toString();
    }

    private boolean mazeSolutionRec(int[][] maze, int i, int j, List<String> path) {
        if (i == maze.length - 1 && j == maze[0].length - 1) {
            path.add("(" + i + "," + j + ")");
            return true;
        }

        int size = maze.length;
        boolean result = false;

        if (i + 1 < size && maze[i + 1][j] != 0) {
            result = mazeSolutionRec(maze, i + 1, j, path);
        }

        if (j + 1 < size && maze[i][j + 1] != 0) {
            result = mazeSolutionRec(maze, i, j + 1, path);
        }

        if (result) {
            path.add("(" + i + "," + j + ")");
        }

        return result;
    }

}
