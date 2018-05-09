package com.oca;

public class CheckIfHopper implements CheckTrait {
    @Override
    public boolean test(Animal animal) {
        return animal.isCanHop();
    }
}
