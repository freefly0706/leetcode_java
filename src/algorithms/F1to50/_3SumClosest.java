/* -*- coding: UTF-8 -*- */
package algorithms.F1to50;

import java.util.Arrays;

public class _3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int highBound = length;
        int closestMin = nums[0] + nums[1] + nums[2];
        int closestMax = nums[length - 3] + nums[length - 2] + nums[length - 1];
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = highBound - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    closestMin = Math.max(closestMin, sum);
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    low++;
                } else {
                    if (low == i + 1) {  //如果当前最小值加上当前最大值比target大,则当前最大值不必再参加后续计算
                        highBound--;
                    }
                    closestMax = Math.min(closestMax, sum);
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    high--;
                }
            }
        }
        if ((target - closestMin) > (closestMax - target)) {
            return closestMax;
        } else {
            return closestMin;
        }
    }
}
