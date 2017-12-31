package algorithms.one2fifty;

public class WildcardMatching {
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
}
