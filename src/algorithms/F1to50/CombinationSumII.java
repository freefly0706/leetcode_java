package algorithms.F1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int candidatesNum = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new LinkedList<>(), 0, candidatesNum, candidates, target);
        return res;
    }

    private void backTracking(List<List<Integer>> res, LinkedList<Integer> combination, int start, int candidatesNum,
                              int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidatesNum; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            backTracking(res, combination, i + 1, candidatesNum, candidates, target - candidates[i]);
            combination.removeLast();
        }
    }
}
