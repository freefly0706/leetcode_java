package algorithms.oneTofifty;

/**
 * Created by fly on 8/15/17.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 == 0) {
            System.err.println("Empty input!");
            System.exit(0);
        }
        int k = (len1 + len2) / 2;
        if ((len1 + len2) % 2 != 0) {
            return getKthSmall(nums1, 0, nums2, 0, k + 1);
        }
        return (getKthSmall(nums1, 0, nums2, 0, k)
                + getKthSmall(nums1, 0, nums2, 0, k + 1)) / 2.0;
    }

    public int getKthSmall(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 > nums1.length - 1) {
            return nums2[start2 + k - 1];
        }
        if (start2 > nums2.length - 1) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) {
            mid1 = nums1[start1 + k / 2 - 1];
        }
        if (start2 + k / 2 - 1 < nums2.length) {
            mid2 = nums2[start2 + k / 2 - 1];
        }
        if (mid1 < mid2) {
            return getKthSmall(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }
        return getKthSmall(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
}
