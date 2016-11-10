import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanwang on 11/9/16.
 */
public class MatrixTopDownPath {
    public static int getMaxPathSum(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i< n; i++){
            dp[0][i] = mat[0][i];
        }


        for(int i = 1; i < m;i++){
            for(int j = 0; j <n; j++){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]) + mat[i][j];
                }else if (j == n-1){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + mat[i][j];
                }else{
                    dp[i][j] = Math.max(Math.max(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]) + mat[i][j];
                }

            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[m-1][i]);
        }
        return max;
    }
    public static List<List<Integer>> getMaxPath(int[][] a, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int m = a.length;
        int n = a[0].length;

        for(int i = 0; i < n; i++){
            List<Integer> path = new ArrayList<>();
            helper(ans, new ArrayList<>(), 0, i, m, n, target, a);
        }
        return ans;
    }

    public static void helper(List<List<Integer>> ans, List<Integer> path,
                              int i, int j, int m, int n, int target, int[][] a){
        if(target < 0 || i<0 || j<0|| i > m-1 || j > n-1){
            return;
        }
        path.add(a[i][j]);
        if(target == a[i][j] && i == m-1){
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        int[][] dir = {{1,-1},{1,0},{1,1}};
        for(int k = 0; k < dir.length; k++) {
            int nx = i + dir[k][0];
            int ny = j + dir[k][1];
            helper(ans, path, nx, ny, m, n, target - a[i][j], a);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[]args){
        int[][] a = {{3, 5, 9, -1},
                     {-4, -3, 0, 3},
                     { 7, 0, -8, 5}};
        int res = getMaxPathSum(a);
        List<List<Integer>> ans = getMaxPath(a, res);
        System.out.println(res);
    }
}
