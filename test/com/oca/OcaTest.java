package com.oca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OcaTest {

    @Test
    public void ocaTest() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish1", true, true));
        animals.add(new Animal("fish2", true, true));
        animals.add(new Animal("fish3", true, true));
        animals.add(new Animal("fish4", true, true));
        animals.add(new Animal("fish5", true, true));

        print(animals, new CheckIfHopper());

        print(animals, (Animal a) -> { return a.isCanHop(); });
    }

    private void print(List<Animal> animals, CheckTrait checkTrait) {

        for (Animal animal : animals) {
            if (checkTrait.test(animal)) {
                System.out.println(animal + " ");
            }
        }
        System.out.println();
    }

}
