/* -*- coding: UTF-8 -*- */
package algorithms.F1to50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int highBound = nums.length;
        int positiveLowBound = 0;
        while (positiveLowBound < highBound && nums[positiveLowBound] <= 0) positiveLowBound++;

        for (int i = 0; i < positiveLowBound; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) continue;
            int low = i + 1, high = highBound - 1,sum;
            while (low < high) {
                sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low + 1] == nums[low]) low++;
                    while (low < high && nums[high - 1] == nums[high]) high--;
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    if (low == i + 1) {  //如果当前最小值加上当前最大值比target大,则当前最大值不必再参加后续计算
                        highBound--;
                    }
                    high--;
                }
            }
        }
        return res;
    }
}
