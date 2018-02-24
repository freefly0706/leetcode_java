package algorithms.F51to100;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

//    /**
//     * 分治算法
//     */
//    public int maxSubArray(int[] nums) {
//        return partition(0, nums.length - 1, nums);
//    }
//
//    public int partition(int low, int high, int[] nums) {
//        if (low == high) {
//            return nums[low];
//        }
//        int mid = (low + high) / 2;
//        int leftMaxSum = partition(low, mid, nums);
//        int rightMaxSum = partition(mid + 1, high, nums);
//        int leftMax = Integer.MIN_VALUE;
//        int rightMax = Integer.MIN_VALUE;
//        int sum = 0;
//        for (int i = mid; i >= low; i--) {
//            sum += nums[i];
//            leftMax = Math.max(leftMax, sum);
//        }
//        sum = 0;
//        for (int i = mid + 1; i <= high; i++) {
//            sum += nums[i];
//            rightMax = Math.max(rightMax, sum);
//        }
//        return Math.max(leftMax + rightMax, Math.max(leftMaxSum, rightMaxSum));
//    }
}
