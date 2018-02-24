/* -*- coding: UTF-8 -*- */
package algorithms.F1to50;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int shortestStrIndex = 0;
        int shortestLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortestLen) {
                shortestStrIndex = i;
                shortestLen = strs[i].length();
            }
        }
        String res = strs[shortestStrIndex];
        for (int i = 0; i < strs.length; ) {
            if (!strs[i].substring(0, shortestLen).equals(res.substring(0, shortestLen))) {
                shortestLen--;
                continue;
            }
            i++;
        }
        return res.substring(0, shortestLen);
    }
}
