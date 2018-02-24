package algorithms.F1to50;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int element : nums) {
            if (element != val) {
                nums[i++] = element;
            }
        }
        return i;
    }
}
