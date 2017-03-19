package com.basic.framework.greedy.algorithm.structure;

public class HuffmanItem implements Comparable<HuffmanItem> {

    private String character;

    private Integer frequency;

    public HuffmanItem(final String character, final Integer frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(final String character) {
        this.character = character;
    }

    public void setFrequency(final Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getFrequency() {
        return frequency;

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        final HuffmanItem that = (HuffmanItem) o;

        return frequency.equals(that.frequency);
    }

    @Override
    public int hashCode() {
        return frequency;
    }

    public int compareTo(final HuffmanItem item) {
        return this.frequency.compareTo(item.getFrequency());
    }
}
