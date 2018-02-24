package algorithms.F1to50;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        char[] pair = new char[2 * n];
        backTracking(pair, n, 0, 0, 0, res);
        return res;
    }

    private void backTracking(char[] pair, int n, int index, int left, int right, List<String> res) {
        if (right == n) {
            res.add(new String(pair));
            return;
        }
        if (left < n) {
            pair[index] = '(';
            backTracking(pair, n, index + 1, left + 1, right, res);
        }
        if (right < left) {
            pair[index] = ')';
            backTracking(pair, n, index + 1, left, right + 1, res);
        }
    }
}
