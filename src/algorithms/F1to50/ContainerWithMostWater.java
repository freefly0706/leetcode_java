/* -*- coding: UTF-8 -*- */
package algorithms.F1to50;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0, minBound;
        while (left < right) {
            minBound = Math.min(height[left], height[right]);
            max = Math.max(max, minBound * (right - left));
            while (left < right && height[left] <= minBound) left++;
            while (right > left && height[right] <= minBound) right--;
        }
        return max;
    }
}
