package com.basic.framework.dynamic.programming;

/**
 * The Floyd-Warshall Algorithm is for solving the All Pairs Shortest Path problem. The problem is to find shortest distances between every pair of
 * vertices in a given edge weighted directed Graph.
 */
class FloydWarshallShortestPath {

    int calculateDP(int[][] distance, int start, int end) {

        int number = distance.length;

        if (number == 0)
            return 0;

        if (distance[0].length != distance.length)
            return 0;

        final int[][] result = new int[number][number];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                result[i][j] = distance[i][j];
            }
        }

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                for (int k = 0; k < number; k++) {
                    if (distance[i][j] + distance[j][k] < distance[i][k]) {
                        distance[i][j] = distance[i][j] + distance[j][k];
                    }
                }
            }
        }

        return distance[start][end];
    }

}
