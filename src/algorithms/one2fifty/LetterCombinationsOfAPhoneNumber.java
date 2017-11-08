/* -*- coding: UTF-8 -*- */
package algorithms.one2fifty;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        int digitsLength = digits.length();
        if (digitsLength == 0) {
            return res;
        }
        String[] digitCorString = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking("", digitCorString, 0, digits, digitsLength, res);
        return res;
    }

    private void backTracking(String combination, String[] digitCorString, int index, String digits,
                              int digitsLength, List<String> res) {
        if (index == digitsLength) {
            res.add(combination);
            return;
        }
        int char2int = digits.charAt(index) - '0';
        for (char c : digitCorString[char2int].toCharArray()) {
            backTracking(combination + c, digitCorString, index + 1, digits, digitsLength, res);
        }
    }
}
