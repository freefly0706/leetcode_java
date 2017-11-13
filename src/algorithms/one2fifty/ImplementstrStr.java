package algorithms.one2fifty;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int needleLength = needle.length();
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + needleLength).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
