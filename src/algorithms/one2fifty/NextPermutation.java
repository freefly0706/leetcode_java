package algorithms.one2fifty;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int numsLength = nums.length;
        int position = numsLength - 1;
        while (position > 0 && nums[position] <= nums[position - 1]) {
            position--;
        }
        if (position != 0) {
            int exchangeIndex = numsLength - 1;
            while (nums[exchangeIndex] <= nums[position - 1]) {
                exchangeIndex--;
            }
            int tmp = nums[position - 1];
            nums[position - 1] = nums[exchangeIndex];
            nums[exchangeIndex] = tmp;
        }
        reverse(nums, position, numsLength);
    }

    public void reverse(int[] nums, int low, int high) {
        for (int i = 0; i < (high - low) / 2; i++) {
            int tmp = nums[low + i];
            nums[low + i] = nums[high - 1 - i];
            nums[high - 1 - i] = tmp;
        }
    }
}
