package com.code.cracking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArraysAndStringsExerciseTest {

    @Test
    public void allUniqueCharactersTest() {
        final ArraysAndStringsExercise exercise = new ArraysAndStringsExercise();

        final String str1 = "string";
        final String str2 = "stringi";
        final String str3 = "stringg";

        assertEquals(true, exercise.stringWithAllUnique(str1));
        assertEquals(false, exercise.stringWithAllUnique(str2));
        assertEquals(false, exercise.stringWithAllUnique(str3));
    }

}
