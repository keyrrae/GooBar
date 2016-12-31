package dfs;

import java.util.HashMap;

/**
 * Created by xuanwang on 12/30/16.
 */
public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] mt) {
        if(mt== null || mt.length == 0 || mt[0] == null || mt[0].length == 0){
            return 0;
        }
        int m = mt.length;
        int n = mt[0].length;
        int[][] mem = new int[m][n];
        int max = 1;
        for(int i =0; i < m;i++){
            for(int j = 0; j< n; j++){
                int len = helper(mt, i, j, m, n, mem);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int helper(int[][] mt, int i, int j, int m, int n, int[][]mem){
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        if(mem[i][j] != 0) return mem[i][j];
        int max = 1;
        for(int[]dir : dirs){
            int x = i+dir[0];
            int y = j+dir[1];

            if(x<0 || x>m-1 || y<0 || y>n-1 || mt[x][y] <= mt[i][j]){
                continue;
            }
            int len = 1+helper(mt, x, y, m, n, mem);
            max = Math.max(max, len);
        }
        mem[i][j] = max;
        return max;

    }
}
