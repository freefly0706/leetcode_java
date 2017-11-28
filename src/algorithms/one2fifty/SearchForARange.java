package algorithms.one2fifty;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low > high) {
            return res;
        }
        int leftHigh = mid - 1;
        int rightLow = mid + 1;
        while (low <= leftHigh) {
            mid = (low + leftHigh) / 2;
            if (nums[mid] != target) {
                low = mid + 1;
            } else {
                leftHigh = mid - 1;
            }
        }
        res[0] = low;
        while (rightLow <= high) {
            mid = (rightLow + high) / 2;
            if (nums[mid] != target) {
                high = mid - 1;
            } else {
                rightLow = mid + 1;
            }
        }
        res[1] = high;
        return res;
    }
}
