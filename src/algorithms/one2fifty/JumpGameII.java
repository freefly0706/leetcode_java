package algorithms.one2fifty;

public class JumpGameII {
    public int jump(int[] nums) {
        int numsLen = nums.length;
        if (numsLen <= 1) {
            return 0;
        }
        int index = 0, jumps = 1;
        while (index + nums[index] < numsLen - 1) {
            jumps++;
            int farthestIndex = 1, farthest = 1 + nums[index + 1];
            for (int i = 2; i <= nums[index]; i++) {  //在当前步长内寻找能走得最远的
                int distance = i + nums[index + i];
                if (distance > farthest) {
                    farthestIndex = i;
                    farthest = distance;
                }
            }
            index += farthestIndex;
        }
        return jumps;
    }
}
