package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanwang on 12/30/16.
 */
public class FlipGame {
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;

        Set<String> winSet = new HashSet<String>();
        return helper(s, winSet);
    }

    public boolean helper(String s, Set<String> winSet){
        if(winSet.contains(s)) return true;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == '+' && s.charAt(i) == '+'){
                String op = s.substring(0, i-1) + "--" + s.substring(i+1);
                if(!helper(op, winSet)){
                    winSet.add(s);
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }

        return list;

    }
}
