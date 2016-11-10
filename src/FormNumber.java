import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuanwang on 11/9/16.
 */
public class FormNumber {
    public static List<Integer> formNum(List<Integer> digits, int target){
        List<Integer> ans = new ArrayList<>();
        if(digits == null|| digits.size() == 0){
            return ans;
        }
        helper(digits, ans, -1, target);

        return ans;
    }
    private static void helper(List<Integer> digits, List<Integer> ans, int path, int target){
        if(path > target){
            return;
        }
        if(path > 0){
            ans.add(path);
        }
        int temp = path;
        for(int i = 0; i < digits.size(); i++){
            if(path == -1){
                path = digits.get(i);
            }else {
                path = path * 10 + digits.get(i);
            }
            helper(digits, ans, path, target);
            path = temp;
        }
    }

    public static List<Integer> formNumUnique(List<Integer> digits, int target){
        List<Integer> ans = new ArrayList<>();
        if(digits == null|| digits.size() == 0){
            return ans;
        }
        boolean[] visited = new boolean[digits.size()];
        uniquehelper(digits, ans, -1, target, visited);

        return ans;
    }
    private static void uniquehelper(List<Integer> digits, List<Integer> ans, int path, int target, boolean[] visited){
        if(path > target){
            return;
        }
        if(path > 0){
            ans.add(path);
        }
        int temp = path;
        for(int i = 0; i < digits.size(); i++){
            if(visited[i]) continue;
            if(path == -1){
                path = digits.get(i);
            }else {
                path = path * 10 + digits.get(i);
            }
            visited[i] = true;
            uniquehelper(digits, ans, path, target,visited);
            path = temp;
            visited[i] = false;
        }
    }
    public static void main(String[] args){
        List<Integer> digits = Arrays.asList(3,7,8);
        int target = 8700;
        List<Integer> ans = formNum(digits, target);
        List<Integer> ans1 = formNumUnique(digits, target);
        System.out.println("Hello");
    }
}
