package algorithms.F51to100;

public class JumpGame {
    public boolean canJump(int[] nums) {
        /**
         * 从后往前扫描，判断当前位置加上当前步数能否到达最后位置
         */
        int lastPos = nums.length - 1;
        for (int i = lastPos - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
