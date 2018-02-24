package algorithms.F1to50;

import java.util.*;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordLength = words[0].length();
        int wordsLength = words.length;
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                wordsMap.replace(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }
        Map<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < wordLength; i++) {
            int count = 0;
            int startIndex = i;
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String substringOut = s.substring(j, j + wordLength);
                if (wordsMap.containsKey(substringOut)) {
                    if (temp.containsKey(substringOut)) {
                        temp.replace(substringOut, temp.get(substringOut) + 1);
                    } else {
                        temp.put(substringOut, 1);
                    }
                    if (temp.get(substringOut) > wordsMap.get(substringOut)) {
                        while (temp.get(substringOut) > wordsMap.get(substringOut)) {
                            String substringIn = s.substring(startIndex, startIndex += wordLength);
                            temp.replace(substringIn, temp.get(substringIn) - 1);
                            count--;
                        }
                    }
                    count++;
                    if (count == wordsLength) {
                        res.add(startIndex);
                        String substringIn = s.substring(startIndex, startIndex += wordLength);
                        temp.replace(substringIn, temp.get(substringIn) - 1);
                        count--;
                    }
                } else {
                    temp.clear();
                    count = 0;
                    startIndex = j + wordLength;
                }
            }
            temp.clear();
        }
        return res;
    }
}