import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _347TopKFrequentElements {
    /*
    Given a non-empty array of integers, return the k most frequent elements.
    Note:
    You may assume k is always valid, 1 <= k <= number of unique elements.
    Your algorithm's time complexity must be better than O(nlogn), where n is the array's size.
    It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
    You can return the answer in any order.
     */
    /*
    minHeap uses O(nlogk) time which is less than O(nlogn). The k = n case will make the time O(nlogn), so it
    will be handled separately at the beginning which is only O(1) time.
     */

    public int[] topKFrequentNumber(int[] nums, int k){
        if (k == nums.length)
            return nums; // special case k = n, handled separately with O(1) time

        // build a HashMap, O(N) time, O(N) space
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // initiate a min heap
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2)
        );

        // Keep k top frequent elements in the heap O(NlogK) time is less than O(NlogN) time.
        for (int n : count.keySet()){
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // 3. build an output array O(klogK) time
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--){
            top[i] = heap.poll();
        }

        return top;
    }
}
