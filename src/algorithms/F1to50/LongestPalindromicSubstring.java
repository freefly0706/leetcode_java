/* -*- coding: UTF-8 -*- */
package algorithms.F1to50;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int sLength = s.length();
        int maxLength = 1;
        int startIndex = 0;
        for (int i = 0; i < sLength; i++) {
            int p = i - 1;
            int q = i + 1;
            while (q < sLength && s.charAt(i) == s.charAt(q)) {
                q++;
            }
            while (p >= 0 && q < sLength && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            if (q - p - 1 > maxLength) {
                startIndex = p + 1;
                maxLength = q - p - 1;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}
