/* -*- coding: UTF-8 -*- */
package algorithms.F1to50;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] M = new boolean[s.length() + 1][p.length() + 1];
        M[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && M[0][i - 1]) {
                M[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    M[i + 1][j + 1] = M[i][j];
                } else if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        M[i + 1][j + 1] = M[i + 1][j - 1];
                    } else {
                        //match 1 time、0 time、multiple times
                        M[i + 1][j + 1] = (M[i + 1][j] || M[i + 1][j - 1] || M[i][j + 1]);
                    }
                }
            }
        }
        return M[s.length()][p.length()];
    }
}
