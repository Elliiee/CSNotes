package Amazon.src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _253MeetingRoomsII {
    // approach 1 priority queue, min-heap
    public int minMeetingRooms(int[][] intervals){
        // base case
        if (intervals.length == 0)
            return 0;

        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(
                intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }

        });

        // sort the intervals by start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // add the first meeting end time
        allocator.add(intervals[0][1]);

        // iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++){
            // if the room is freed up, then assign that room to this meeting.
            if (intervals[i][0] >= allocator.poll()){
                allocator.poll();
            }
            // if a new room needed to be assigned, also add that to the heap.
            // if an old room is reassigned, we only need to change the end time at the heap.
            // this 2 scenarios can be achieved by one step
            allocator.add(intervals[i][1]);

        }
        // the size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}
