package com.basic.framework.structures;

/**
 * With path compression and union by rank - running time for n nodes and n - 1 union is O(mL(n))
 * where L(n) is slowly growing function ~4 which gives us O(4m) == O(m) running time
 * Space complexity is O(n)
 */
public class DisjointSet {

    private Map<Long, SetNode> setNodeMap = new HashMap<Long, SetNode>();

    // O(1)
    public void makeSet(final Long data) {
        final SetNode node = new SetNode();

        node.data = data;
        node.parent = node;
        node.rank = 0;

        setNodeMap.put(data, node);
    }


    public long findSet(final Long data) {
        return findSetRec(setNodeMap.get(data)).data;
    }

    // Path compression inside find set
    private SetNode findSetRec(final SetNode node) {
        if (node == node.parent)
            return node;

        node.parent = findSetRec(node.getParent());
        return node.parent;
    }

    public void union(final Long dataFirst, final Long dataSecond) {
        final SetNode nodeFirst = setNodeMap.get(dataFirst);
        final SetNode nodeSecond = setNodeMap.get(dataSecond);

        final SetNode rootFirst = findSetRec(nodeFirst);
        final SetNode rootSecond = findSetRec(nodeSecond);

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

        private long data;

        private SetNode parent;

        public int getRank() {
            return rank;
        }

        public void setRank(final int rank) {
            this.rank = rank;
        }

        public long getData() {
            return data;
        }

        public void setData(final long data) {
            this.data = data;
        }

        public SetNode getParent() {
            return parent;
        }

    }

}
