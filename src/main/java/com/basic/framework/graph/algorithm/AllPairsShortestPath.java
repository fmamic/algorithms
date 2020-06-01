package com.basic.framework.graph.algorithm;

import com.basic.framework.graph.GraphMatrix;

public class AllPairsShortestPath {
    
    public int[][][] allPairShortestPath(GraphMatrix graphMatrix) {
        int[][][] memo = new int[graphMatrix.getSize() + 1][graphMatrix.getSize() + 1][graphMatrix.getSize() + 1];

        for (int i = 0; i <= graphMatrix.getSize(); i++) {
            for (int k = 0; k <= graphMatrix.getSize(); k ++) {
                for (int l = 0; l <= graphMatrix.getSize(); l++) {
                    memo[i][k][l] = Integer.MAX_VALUE;
                }
            }
        }

        allPairShortestPathRecursive(graphMatrix, 0, graphMatrix.getSize(), graphMatrix.getSize(), memo);

        return memo;
    }

    public int allPairShortestPathRecursive(GraphMatrix graphMarix, int i, int j, int m, int[][][] memo) {

        if (i == j) 
            return 0;

        if (m == 0) {
            return Integer.MAX_VALUE;
        }

        int min = memo[i][j][m];
        
        for (int k = 0; k <= graphMarix.getSize(); k++) {
            
            int value = allPairShortestPathRecursive(graphMarix, i, k, m - 1, memo);
            
            if (value == Integer.MAX_VALUE || graphMarix.matrix[k][j] == Integer.MAX_VALUE) 
                continue;

            int calc = value + graphMarix.matrix[k][j];

            if (calc < min) {
                min = calc; 
            }
        }

        memo[i][j][m] = min;

        return min;
    }

    // O(V^4)
    public int[][] slowAllPairsShortestPath(GraphMatrix graphMatrix) {
        int n = graphMatrix.getSize() + 1;
        int[][] l = graphMatrix.matrix;
        
        for (int i = 2; i < n; i++) {
            l = extendShortestPath(graphMatrix.matrix, l);
        }

        return l;
    }

    public int[][] fastAllPairShortestPath(GraphMatrix graphMatrix) {
        int n = graphMatrix.getSize() + 1;
        int[][] l = graphMatrix.matrix;
        int m = 1;

        while (m < n - 1) {
            l = extendShortestPath(l, l);
            m *= 2;
        }

        return l;
    }

    public int[][] extendShortestPath(int[][] graphMatrix, int[][] shortestPath) {
        int n = graphMatrix.length;
        int[][] l = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                l[i][j] = Integer.MAX_VALUE;

                for (int k = 0; k < n; k++) {
                    if (graphMatrix[i][k] == Integer.MAX_VALUE || shortestPath[k][j] == Integer.MAX_VALUE)
                        continue;

                    l[i][j] = Math.min(l[i][j], graphMatrix[i][k] + shortestPath[k][j]);
                }
            }
        }

        return l;
    }
}