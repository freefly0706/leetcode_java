package algorithms.F1to50;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fly on 8/11/17.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> elements = new HashMap<>();
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            if (elements.containsKey(temp)){
                result[0] = elements.get(temp);
                result[1] = i;
                return result;
            }else{
                elements.put(nums[i],i);
            }
        }
        return null;
    }
}
