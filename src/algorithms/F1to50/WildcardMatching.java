package algorithms.F1to50;

public class WildcardMatching {
    //贪心
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int i = 0, j = 0, sIndex = 0, pIndex = -1;
        while (i < sLen) {
            if (j < pLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pLen && p.charAt(j) == '*') {
                sIndex = i;
                pIndex = ++j;
            } else if (pIndex != -1) {
                i = ++sIndex;
                j = pIndex;
            } else {
                return false;
            }
        }
        while (j < pLen && p.charAt(j) == '*') j++;
        return j == pLen;
    }

    /*动规
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] M = new boolean[sLen + 1][pLen + 1];
        M[0][0] = true;
        for (int i = 0; i < pLen && p.charAt(i) == '*'; i++) {
            M[0][i + 1] = true;
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    M[i + 1][j + 1] = M[i][j];
                } else if (p.charAt(j) == '*') {
                    //‘*’匹配0次、‘*’匹配1次、‘*’匹配多次
                    M[i + 1][j + 1] = M[i + 1][j] || M[i][j] || M[i][j + 1];
                }
            }
        }
        return M[sLen][pLen];
    }
    */
}
