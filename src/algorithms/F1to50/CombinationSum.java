package algorithms.F1to50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int candidatesNum = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new LinkedList<>(), 0, candidatesNum, candidates, target);
        return res;
    }

    private void backTracking(List<List<Integer>> res, LinkedList<Integer> combination, int start, int candidatesNum,
                              int[] candidates, int target) {
        if (start == candidatesNum || target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(combination));
            }
            return;
        }
        combination.add(candidates[start]);  //包含candidates[start]的情况
        backTracking(res, combination, start, candidatesNum, candidates, target - candidates[start]);

        combination.removeLast();  //不包含candidates[start]的情况
        backTracking(res, combination, start + 1, candidatesNum, candidates, target);
    }
}
