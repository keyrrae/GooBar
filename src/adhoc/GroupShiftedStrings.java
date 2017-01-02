package adhoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanwang on 1/1/17.
 */

/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */
public class GroupShiftedStrings {
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
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(s);
        }

        for(List<String> l: map.values()){
            ans.add(l);
        }
        return ans;
    }
}
