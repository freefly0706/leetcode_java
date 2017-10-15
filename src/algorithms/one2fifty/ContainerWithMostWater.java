/* -*- coding: UTF-8 -*- */
package algorithms.one2fifty;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0, minBound;
        while (left < right) {
            minBound = Math.min(height[left], height[right]);
            max = Math.max(max, minBound * (right - left));
            while (left < height.length && height[left] <= minBound) left++;
            while (right > 0 && height[right] <= minBound) right--;
        }
        return max;
    }
}
