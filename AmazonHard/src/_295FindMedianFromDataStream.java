package AmazonHard.src;

import java.util.*;

public class _295FindMedianFromDataStream {
    List<Integer> list = new ArrayList<>();

    public _295FindMedianFromDataStream(){ }

    public void addNum(int num){
        list.add(num);
    }

    public double findMedian(){
        Collections.sort(list);
        int n = list.size();
        if ((n & 1) == 1){
            return list.get(n / 2);
        } else {
            return ((double) list.get(n / 2) + list.get(n / 2 - 1)) / 2;
        }
    } // time complexity O(NlogN)


    // approach 2 sort when add the num
    public void addNumII(int num){
        int i = 0;
        for (; i < list.size(); i++){
            if (num < list.get(i)){
                break;
            }
        }
        list.add(i, num);
    } // time complexity O(N)

    public double findMedianII(){
        int n = list.size();
        if ((n & 1) == 1){
            return list.get(n / 2);
        } else {
            return ((double) list.get(n/2) + list.get(n/2 - 1)) / 2;
        }
    } // O(1)

    // approach 3 priority queue
    Queue<Integer> leftQueue = new PriorityQueue<>((i1, i2)->{
        return i2 - i1;  // left queue is the max priority queue
    });
    Queue<Integer> rightQueue = new PriorityQueue<>(); // right queue is the min priority queue

    public void addNumIII(int num){
        int leftSize = leftQueue.size();
        int rightSize = rightQueue.size();

        // when left and right numbers are equal
        if (leftSize == rightSize){
            if (leftSize == 0){ // when left does not have number, add to the left
                leftQueue.add(num);
                return;
            }

            // if the num is less or equal than the minimum number of the right site,
            // it should be at the left site
            if (num <= rightQueue.peek()){
                leftQueue.add(num);
            }
            else { // if the num is more than the minimum of the right site, it should be at right site.
                leftQueue.add(rightQueue.poll()); // to balance the two side, move 1 to left site
                rightQueue.add(num); // put the num to the right site
            }
        }
        else {
            // if num is bigger than the max of the left side, it belongs to the right side
            if (num >= leftQueue.peek()){
                rightQueue.add(num);
            }
            else {
                rightQueue.add(leftQueue.poll()); // to balance the two side, move 1 out of right side
                leftQueue.add(num); // put the num at the left side
            }
        }
    }

    public double findMedianIII(){
        if (leftQueue.size() > rightQueue.size()){
            return leftQueue.peek();
        }
        else {
            return ((double) leftQueue.peek() + rightQueue.peek()) / 2;
        }
    }
}


