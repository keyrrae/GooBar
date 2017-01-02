package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanwang on 12/31/16.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            if(!map.containsKey(n)){
                int left = map.getOrDefault(n-1, 0);
                int right = map.getOrDefault(n+1, 0);
                int sum = left+right+1;
                map.put(n, sum);

                res = Math.max(res, sum);
                map.put(n-left,sum);
                map.put(n+right, sum);
            }
        }
        return res;
    }
}
