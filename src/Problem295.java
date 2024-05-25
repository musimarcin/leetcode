//Implement the MedianFinder class:
//
//MedianFinder() initializes the MedianFinder object.
//void addNum(int num) adds the integer num from the data stream to the data structure.
//double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Problem295 {

    class MedianFinder {
        // max-heap to store the smaller half of the numbers
        private PriorityQueue<Integer> smallHeap;
        // min-heap to store the larger half of the numbers
        private PriorityQueue<Integer> largeHeap;

        // initialize the MedianFinder object.
        public MedianFinder() {
            smallHeap = new PriorityQueue<>((a, b) -> b - a); // Max-heap
            largeHeap = new PriorityQueue<>(); // Min-heap
        }

        public void addNum(int num) {
            // add a number to smallHeap of its smaller than maximum of smallHeap otherwise add to largeHeap
            if (smallHeap.isEmpty() || num <= smallHeap.peek()) {
                smallHeap.add(num);
            } else {
                largeHeap.add(num);
            }
            // balance size of the heaps
            if (smallHeap.size() > largeHeap.size() + 1) {
                largeHeap.add(smallHeap.poll());
            } else if (largeHeap.size() > smallHeap.size()) {
                smallHeap.add(largeHeap.poll());
            }
        }

        public double findMedian() {
            if (smallHeap.size() == largeHeap.size()) {
                return (smallHeap.peek() + largeHeap.peek()) / 2.0;
            } else {
                return smallHeap.peek();
            }
        }
    }
}
