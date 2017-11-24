package algorithms.one2fifty;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int sLength = s.length();
        if (sLength <= 1) {
            return 0;
        }
        int[] L = new int[sLength];
        if (s.charAt(0) == '(' && s.charAt(1) == ')') {
            L[1] = 2;
        }
        int longest = L[1];
        for (int i = 2; i < sLength; i++) {
            if (s.charAt(i) == ')') {
                int left = i - 1 - L[i - 1];
                if (L[i - 1] >= 2 && left >= 0 && s.charAt(left) == '(') {
                    L[i] = L[i - 1] + 2;
                    if (left - 1 >= 0) {
                        L[i] += L[left - 1];
                    }
                } else if (s.charAt(i - 1) == '(') {
                    L[i] = L[i - 2] + 2;
                }
                longest = Math.max(longest, L[i]);
            }
        }
        return longest;
    }
}
