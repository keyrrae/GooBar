import java.util.*;

/**
 * Created by xuanwang on 11/9/16.
 */
public class AverageSizeN {
    // 第二题: 已知k个sorted array of int, return 一个 sorted array. 其中每个array的average size是N. 用Heap(priority queue)做，O(Nklogk)时间O(Nk)空间。
    public static List<Integer> mergeKSortedLists(List<List<Integer>> arr){
        List<Integer> ans = new ArrayList<>();
        Queue<Tuple> q = new PriorityQueue<>((a, b)-> a.val-b.val);
        for(int i = 0; i < arr.size(); i++){
            q.offer(new Tuple(i, 0, arr.get(i).get(0)));
        }

        while(!q.isEmpty()){
            Tuple t = q.poll();
            ans.add(t.val);
            if(t.y == arr.get(t.x).size()-1) continue;
            q.offer(new Tuple(t.x, t.y+1, arr.get(t.x).get(t.y+1)));
        }
        return ans;
    }


    public static class Tuple{
        int x, y, val;
        Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args){
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(2,6), Arrays.asList(5,9,10,12));
        List<Integer> ans = mergeKSortedLists(arr);
        System.out.println("hello");
    }
}
