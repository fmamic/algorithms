package com.leet.code;

import java.util.*;

public class DistinctSubsequence {

    public int numDistinct(String s, String t) {

        char[] output = new char[s.length()];
        int[] count = new int[s.length()];

        Arrays.fill(count, 1);

        return numDistinct(s.toCharArray(), count, 0, t, output, 0);
    }

    private int numDistinct(char[] str, int[] count, int pos, final String t, char[] output, int len) {
        int number = 0;

        System.out.println(String.valueOf(Arrays.copyOf(output, len)));
        if (String.valueOf(Arrays.copyOf(output, len)).equals(t)) {
            number++;
        }

        for (int i = pos; i < str.length; i++) {
            if (count[i] != 0) {
                count[i] = count[i] - 1;
                output[len] = str[i];
                number += numDistinct(str, count, i, t, output, len + 1);
                count[i] = count[i] + 1;
            }
        }

        return number;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Stack<UndirectedGraphNode> stack = new Stack<>();
        Map<Integer, UndirectedGraphNode> visited = new HashMap<>();

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        stack.push(node);
        visited.put(clone.label, clone);

        while (!stack.isEmpty()) {
            UndirectedGraphNode stackNode = stack.peek();

            boolean hasNeighbor = false;
            for (UndirectedGraphNode neighbor : stackNode.neighbors) {
                if (!visited.containsKey(neighbor.label)) {
                    stack.push(neighbor);
                    hasNeighbor = true;

                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    visited.get(stackNode.label).neighbors.add(newNeighbor);
                    visited.put(neighbor.label, newNeighbor);
                    break;
                } else {
                    visited.get(stackNode.label).neighbors.add(visited.get(neighbor.label));
                }
            }

            if (!hasNeighbor) {
                stack.pop();
            }
        }

        return clone;
    }

    public static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    ;
}
