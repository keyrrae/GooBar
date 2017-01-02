package adhoc;

import java.util.*;
/**
 * Created by xuanwang on 1/1/17.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();

        if(matrix == null || matrix.length == 0 || matrix[0] == null|| matrix[0].length == 0){
            return ans;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int a = 0;
        int b = 0;

        while ( a < (m + 1) / 2 && b < (n + 1) / 2 ){
            if ( 2 * a +1==m && 2*b+1==n){
                ans.add(matrix[a][b]);
                break;
            } else if( 2*a+1==m){
                for(int j = b; j < n-b;j++){
                    ans.add(matrix[a][j]);
                }
                break;
            } else if( 2*b + 1 == n){
                for(int i = a; i < m - a; i++){
                    ans.add(matrix[i][b]);
                }
                break;
            }

            for(int j = b; j < n-b-1; j++){
                ans.add(matrix[a][j]);
            }

            for(int i = a; i< m-a-1; i++){
                ans.add(matrix[i][n-b-1]);
            }

            for(int j = n-b-1; j>b; j--){
                ans.add(matrix[m-a-1][j]);
            }

            for(int i = m-a-1; i>a; i--){
                ans.add(matrix[i][b]);
            }
            a++;b++;

        }


        return ans;
    }
}
