package com.leet.code;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PalindromeMinCutsTest {

    @Test
    public void minCutsTest() {
        PalindromeMinCuts palindromeMinCuts = new PalindromeMinCuts();
        int result = palindromeMinCuts.minCut("gulgklbababcbcb");

        assertEquals(8, result);
    }

}
