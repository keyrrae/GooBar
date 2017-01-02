package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanwang on 1/1/17.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String path, int open, int close, int max){

        if(path.length() == max*2){
            list.add(path);
            return;
        }

        if(open < max)
            backtrack(list, path+"(", open+1, close, max);
        if(close < open)
            backtrack(list, path+")", open, close+1, max);
    }
}
