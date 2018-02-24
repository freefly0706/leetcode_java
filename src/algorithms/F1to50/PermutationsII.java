package algorithms.F1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
                while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }
    }
}
