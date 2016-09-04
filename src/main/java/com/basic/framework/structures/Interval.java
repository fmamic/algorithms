package com.basic.framework.structures;

import java.lang.Comparable;

class Interval implements Comparable<Interval> {

    private Integer minimum;

    private Integer maximum;

    Interval(final Integer minimum, final Integer maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    boolean overlap(final Interval interval) {
        return !(this.maximum < interval.minimum || this.minimum > interval.maximum);
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    Integer getMinimum() {
        return minimum;
    }

    @Override
    public String toString() {
        return "[" + minimum + " , " + maximum + "]";
    }

    @SuppressWarnings("unchecked")
    public int compareTo(final Interval param) {
        return minimum.compareTo(param.getMinimum());
    }
}
