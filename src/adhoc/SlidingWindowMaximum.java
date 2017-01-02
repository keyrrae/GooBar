package adhoc;

import java.util.ArrayDeque;

/**
 * Created by xuanwang on 12/31/16.
 */
public class SlidingWindowMaximum {
    /*    Explanation

    The basic idea is referred from here: use two-ends deque to make the first element in the deque is the largest number in the window, and keep the above steps recursively.

    Time complexity is O(n), as each number in the array is only offered or polled once.

    Code is as the following:
            */
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) return new int[0];
        int[] res = new int[a.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        int index  = 0;
        for (int i = 0; i < a.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) // Ensure deque's size doesn't exceed k
                deque.poll();

            // Remove numbers smaller than a[i] from right(a[i-1]) to left, to make the first number in the deque the largest one in the window
            while (!deque.isEmpty() && a[deque.peekLast()] < a[i])
                deque.pollLast();

            deque.offer(i);// Offer the current index to the deque's tail

            if (i >= k - 1)// Starts recording when i is big enough to make the window has k elements
                res[index++] = a[deque.peek()];
        }
        return res;
    }

}
