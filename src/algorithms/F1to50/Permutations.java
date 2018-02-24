package algorithms.F1to50;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void backTracking(List<List<Integer>> res, ArrayList<Integer> permutation,
                             int[] nums, boolean[] hasIncluded) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!hasIncluded[i]) {
                permutation.add(nums[i]);
                hasIncluded[i] = true;
                backTracking(res, permutation, nums, hasIncluded);
                permutation.remove(permutation.size() - 1);
                hasIncluded[i] = false;
            }
        }
    }
}
