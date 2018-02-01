package com.leet.code;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DistinctSubsequenceTest {

    @Test
    public void distinctSubsequenceTest() {
        final DistinctSubsequence distinctSubsequence = new DistinctSubsequence();
        int result = distinctSubsequence.numDistinct("rabbbit","rabbit");

        assertEquals(3, result);
    }

    @Test
    public void graphClone() {
        final DistinctSubsequence distinctSubsequence = new DistinctSubsequence();

        DistinctSubsequence.UndirectedGraphNode node1 = new DistinctSubsequence.UndirectedGraphNode(1);
        DistinctSubsequence.UndirectedGraphNode node2 = new DistinctSubsequence.UndirectedGraphNode(2);
        DistinctSubsequence.UndirectedGraphNode node3 = new DistinctSubsequence.UndirectedGraphNode(3);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node3);

        node3.neighbors.add(node3);

        DistinctSubsequence.UndirectedGraphNode clone = distinctSubsequence.cloneGraph(node1);
        assertEquals(null, clone);
    }
}
