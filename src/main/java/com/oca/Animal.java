package com.oca;

public class Animal {

    private String spicies;

    private boolean canHop;

    private boolean canSwim;

    public Animal(String spicies, boolean canHop, boolean canSwim) {
        this.spicies = spicies;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public String getSpicies() {
        return spicies;
    }
}
