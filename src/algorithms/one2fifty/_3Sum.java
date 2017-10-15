/* -*- coding: UTF-8 -*- */
package algorithms.one2fifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int positiveLowBound = 0;
        while (positiveLowBound < nums.length && nums[positiveLowBound] <= 0) positiveLowBound++;

        for (int i = 0; i < positiveLowBound; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) continue;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low + 1] == nums[low]) low++;
                    while (low < high && nums[high - 1] == nums[high]) high--;
                    low++;
                    high--;
                } else if (nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}
