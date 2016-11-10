import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanwang on 11/9/16.
 */
public class OneCharEachArray {
    public static List<String> oneCharEach(char[][] a){
        List<String> ans = new ArrayList<>();
        if(a == null || a.length == 0){
            return ans;
        }

        helper(ans, new StringBuilder(), a, 0);
        return ans;
    }

    public static void helper(List<String>ans, StringBuilder path, char[][] a, int pos){
        if(path.length() == a.length){
            ans.add(path.toString());
            return;
        }
        char[] cur = a[pos];
        for(int i = 0; i < cur.length; i++){
            path.append(cur[i]);
            helper(ans, path, a, pos+1);
            path.setLength(path.length()-1);
        }
    }

    public static void main(String[]args){
        char[][] a = {{'a', 'b', 'c', 'd'}, {'e', 'f'}, {'m', 'n', 'o'}};
        List<String> ans = oneCharEach(a);
        System.out.println("Hello");
    }
}
