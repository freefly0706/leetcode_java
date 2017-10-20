/* -*- coding: UTF-8 -*- */
package algorithms.one2fifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int highBound = nums.length;
        for (int i = 0; i < highBound - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[highBound - 1] + nums[highBound - 2] + nums[highBound - 3] < target) continue;
            if (i > 0 && (nums[i] == nums[i - 1])) continue;
            for (int j = i + 1; j < highBound - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[highBound - 1] + nums[highBound - 2] < target) continue;
                if (j > i + 1 && (nums[j] == nums[j - 1])) continue;
                int low = j + 1, high = highBound - 1, sum;
                while (low < high) {
                    sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low + 1] == nums[low]) low++;
                        while (low < high && nums[high - 1] == nums[high]) high--;
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        if (low == i + 2) {  //如果当前最小值加上当前最大值比target大,则当前最大值不必再参加后续计算
                            highBound--;
                        }
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
