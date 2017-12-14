package algorithms.one2fifty;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int numLength = nums.length;
        for (int i = 0; i < numLength; ) {
            int num = nums[i];
            if (num <= numLength && num > 0 && nums[num - 1] != num) {
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
            } else {
                i++;
            }
        }
        int i = 0;
        for (; i < numLength; i++) {
            if (nums[i] != i + 1) {
                break;
            }
        }
        return i + 1;
    }
}
