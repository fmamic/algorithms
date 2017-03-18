package com.basic.framework.structures;

/**
 * With path compression and union by rank - running time for n nodes and n - 1 union is O(mL(n))
 * where L(n) is slowly growing function ~4 which gives us O(4m) == O(m) running time
 * Space complexity is O(n)
 */
public class DisjointSet {

    private Map<Integer, SetNode> setNodeMap = new HashMap<Integer, SetNode>();

    // O(1)
    public void makeSet(final Integer data) {
        final SetNode node = new SetNode();

        node.data = data;
        node.parent = node;
        node.rank = 0;

        setNodeMap.put(data, node);
    }


    public Integer findSet(final Integer data) {
        return findSetRec(setNodeMap.get(data)).data;
    }

    // Path compression inside find set - O(logN)
    private SetNode findSetRec(final SetNode node) {
        if (node == node.parent)
            return node;

        node.parent = findSetRec(node.getParent());
        return node.parent;
    }

    // O(logN) - best case for N unions is O(N)
    public void union(final Integer dataFirst, final Integer dataSecond) {
        final SetNode nodeFirst = setNodeMap.get(dataFirst);
        final SetNode nodeSecond = setNodeMap.get(dataSecond);

        final SetNode rootFirst = findSetRec(nodeFirst); // O(logN)
        final SetNode rootSecond = findSetRec(nodeSecond); // O(logN)

        if (rootFirst != rootSecond) {
            if (rootFirst.getRank() >= rootSecond.getRank()) {
                if (rootFirst.rank == rootSecond.rank) {
                    rootFirst.rank++;
                }
                rootSecond.parent = rootFirst;
            } else {
                rootFirst.parent = rootSecond;
            }
        }
    }

    public static class SetNode {

        private int rank;

        private Integer data;

        private SetNode parent;

        public int getRank() {
            return rank;
        }

        public Integer getData() {
            return data;
        }

        public void setData(final Integer data) {
            this.data = data;
        }

        public SetNode getParent() {
            return parent;
        }

    }

}
