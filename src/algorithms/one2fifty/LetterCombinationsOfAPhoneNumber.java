/* -*- coding: UTF-8 -*- */
package algorithms.one2fifty;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        }
        String[] pairs = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking("", pairs, 0, digits, res);
        return res;
    }

    private void backTracking(String combination, String[] pairs, int index, String digits, List<String> res) {
        if (index == digits.length()) {
            res.add(combination);
            return;
        }
        int char2int = digits.charAt(index) - '0';
        for (int i = 0; i < pairs[char2int].length(); i++) {
            backTracking(combination + pairs[char2int].charAt(i), pairs, index + 1, digits, res);
        }
    }
}
