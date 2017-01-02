package arrays;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xuanwang on 1/1/17.
 */

/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        Queue<Tuple> q = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(int i = 0; i < m ;i++){
            q.offer(new Tuple(0, i, matrix[0][i]));
        }
        for(int i = 0; i < k - 1; i++){
            Tuple t = q.poll();
            if(t.x == m-1) continue;
            q.offer(new Tuple(t.x+ 1, t.y, matrix[t.x+1][t.y]));
        }

        return q.poll().val;
    }

    class Tuple{
        int x, y, val;
        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
