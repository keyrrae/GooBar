package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanwang on 1/1/17.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return helper(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> helper(String s, Set<String> wd, HashMap<String, List<String>> m){
        if(m.containsKey(s)){
            return m.get(s);
        }

        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for(String w: wd){
            if(s.startsWith(w)){
                List<String> br = helper(s.substring(w.length()), wd, m);
                for(String str: br){
                    res.add(w + (str.isEmpty()? "": " ") + str);
                }

            }
        }
        m.put(s, res);
        return res;
    }
}
