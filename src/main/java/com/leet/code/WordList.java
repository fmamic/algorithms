package com.leet.code;

import java.util.*;

public class WordList {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int min = dfs(beginWord, endWord, wordList, 0, new HashSet<>(List.of(beginWord)));
        return bfs(beginWord, endWord, wordList);
    }

    public int bfs(String beginWord, String endWord, List<String> wordList) {

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);

        int level = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            while (levelSize != 0) {

                String word = queue.poll();

                if (word == null)
                    return 0;

                if (word.equals(endWord)) {
                    return level + 1;
                }

                for (String wordInList : wordList) {

                    if (!visited.contains(wordInList) && isSingleDiff(wordInList, word)) {
                        queue.add(wordInList);
                        visited.add(wordInList);
                    }

                }

                levelSize--;
            }

            level++;
        }

        return 0;
    }

    public int dfs(String beginWord, String endWord, List<String> wordList, int total, Set<String> checked) {

        if (beginWord.equals(endWord)) {
            return total;
        }

        int minimum = 0;

        for (int i = 0; i < wordList.size(); i++) {

            String word = wordList.get(i);

            if (!checked.contains(word) && isSingleDiff(beginWord, word)) {

                checked.add(word);

                int value = dfs(word, endWord, wordList, total + 1, checked);

                checked.remove(word);

                minimum = minimum != 0 && value != 0 ? Math.min(minimum, value) : (minimum != 0 ? minimum : value);
            }

        }

        return minimum;
    }

    private boolean isSingleDiff(String w1, String w2) {

        char[] w1c = w1.toCharArray();
        char[] w2c = w2.toCharArray();

        int diff = 0;

        for (int i = 0; i < w1c.length; i++) {
            if (w1c[i] != w2c[i]) {
                diff++;
            }

            if (diff > 1) {
                return false;
            }
        }

        return diff == 1;
    }
}
