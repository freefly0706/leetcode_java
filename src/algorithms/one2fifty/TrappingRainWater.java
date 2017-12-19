package algorithms.one2fifty;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int sum = 0, minBound;
        int left = 0, right = height.length - 1;
        while (left < right) {
            minBound = Math.min(height[left], height[right]);
            while (left < right && height[left] <= minBound) {
                sum += minBound - height[left];
                left++;
            }
            while (right > left && height[right] <= minBound) {
                sum += minBound - height[right];
                right--;
            }
        }
        return sum;
    }
}
