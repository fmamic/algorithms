package com.leet.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordListTest {

    @Test
    public void WordListLadderCount() {
        WordList wordList = new WordList();

        List<String> input = new ArrayList<String>(List.of("hot", "dog", "cog"));

        wordList.ladderLength("hot", "dog", input);
    }

}
