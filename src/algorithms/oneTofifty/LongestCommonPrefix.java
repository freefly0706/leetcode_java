/* -*- coding: UTF-8 -*- */
package algorithms.oneTofifty;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int shortestStrIndex = 0;
        int shortestLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortestLen) {
                shortestStrIndex = i;
                shortestLen = strs[i].length();
            }
        }
        String shortestStr = strs[shortestStrIndex];
        for (int i = 0; i < shortestLen; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (shortestStr.charAt(i) != strs[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(shortestStr.charAt(i));
        }
        return res.toString();
    }
}
