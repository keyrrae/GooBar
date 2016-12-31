package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanwang on 12/19/16.
 */
public class GroupRotatedStrings {
    public List<List<String>> groupStrings(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return ans;
        }
        for(String s: strs){
            StringBuilder sb = new StringBuilder();
            for(int i = 1;i< s.length(); i++){
                int diff = s.charAt(i) - s.charAt(0);
                sb.append((diff +26)%26);
                sb.append(',');
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        for(List<String> l: map.values()){
            ans.add(l);
        }
        return ans;
    }
}
