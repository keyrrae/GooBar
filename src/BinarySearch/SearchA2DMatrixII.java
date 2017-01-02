package BinarySearch;

/**
 * Created by xuanwang on 1/1/17.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] m, int t) {
        if(m == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return false;
        }

        int i = m.length-1;
        int j = 0;
        while(j<=m[0].length-1 && i>=0){
            if(m[i][j] == t) return true;
            if(m[i][j] > t) i--;
            else if(m[i][j] <t) j++;
        }
        return false;
    }
}
