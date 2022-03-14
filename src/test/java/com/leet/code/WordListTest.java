package com.leet.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordListTest {

    @Test
    public void WordListLadderCount() {
        WordList wordList = new WordList();

        List<String> input = new ArrayList<>(List.of("hot", "dog", "cog", "pot", "dot"));

        int output = wordList.ladderLength("hot", "dog", input);

        Assert.assertEquals(output, 3);
    }

}
