/* -*- coding: UTF-8 -*- */
package algorithms.one2fifty;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        int digitsLength = digits.length();
        List<String> res = new LinkedList<>();
        if (digitsLength == 0) {
            return res;
        }
        Map<Character, String> digitCorString = new HashMap<>();
        digitCorString.put('2', "abc");
        digitCorString.put('3', "def");
        digitCorString.put('4', "ghi");
        digitCorString.put('5', "jkl");
        digitCorString.put('6', "mno");
        digitCorString.put('7', "pqrs");
        digitCorString.put('8', "tuv");
        digitCorString.put('9', "wxyz");
        String lastDigitLetterCombi = digitCorString.get(digits.charAt(digitsLength - 1));
        for (int i = 0; i < lastDigitLetterCombi.length(); i++) {
            res.add("" + lastDigitLetterCombi.charAt(i));
        }
        for (int i = digits.length() - 2; i >= 0; i--) {
            String letterCombi = digitCorString.get(digits.charAt(i));
            int resLength = res.size();
            for (int k = 0; k < resLength; k++) {
                String temp = res.remove(0);
                for (char c : letterCombi.toCharArray()) {
                    res.add(c + temp);
                }
            }
        }
        return res;
    }
}
