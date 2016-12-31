package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanwang on 12/30/16.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums==null || nums.length<1) return  res;

        int s=0, e=0;
        while(e<nums.length) {
            if(e+1<nums.length && nums[e+1]==nums[e]+1) {
                e++;
            } else {
                if(s==e) {
                    res.add(Integer.toString(nums[s]));
                } else {
                    String str = nums[s] + "->" + nums[e];
                    res.add(str);
                }
                ++e;
                s = e;
            }
        }
        return res;
    }
}
