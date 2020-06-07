import java.util.Arrays;

public class _912SortAnArray {
    // merge sort
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1)
            return nums;
        int pivot = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;
        while(leftIndex < left.length &&
                rightIndex < right.length){
            if (left[leftIndex] < right[rightIndex])
                result[resultIndex++] = left[leftIndex++];
            else
                result[resultIndex++] = right[rightIndex++];
        }

        while (leftIndex < left.length)
            result[resultIndex++] = left[leftIndex++];

        while (rightIndex < right.length)
            result[resultIndex++] = right[rightIndex++];

        return result;

    }
}
