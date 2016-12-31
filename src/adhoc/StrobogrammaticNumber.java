package adhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuanwang on 12/19/16.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0){
            return true;
        }
        int start = 0, end = num.length()-1;
        while(start <= end){
            char a = num.charAt(start++);
            char b = num.charAt(end--);
            if(a == '6' && b == '9') continue;
            if(a == '9' && b == '6') continue;
            if(a == '8' && b == '8') continue;
            if(a == '1' && b == '1') continue;
            if(a == '0' && b == '0') continue;
            return false;
        }
        return true;
    }

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int curlen, int totalLen){
        if(curlen == 0) return new ArrayList<>(Arrays.asList(""));
        if(curlen == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> l = helper(curlen-2, totalLen);
        List<String> ans = new ArrayList<>();
        for(String s: l){
            if(curlen != totalLen){
                ans.add("0" + s + "0");
            }

            ans.add("1" + s + "1");
            ans.add("9" + s + "6");
            ans.add("6" + s + "9");
            ans.add("8" + s + "8");
        }
        return ans;
    }

}
