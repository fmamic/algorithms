package com.basic.framework.graph.algorithm;

import com.basic.framework.graph.GraphMarix;

public class AllPairsShortestPath {
    
    public int[][][] allPairShortestPath(GraphMarix graphMatrix) {
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

    public int allPairShortestPathRecursive(GraphMarix graphMarix, int i, int j, int m, int[][][] memo) {

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
}