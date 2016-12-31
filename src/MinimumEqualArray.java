import java.util.Arrays;

/**
 * Created by xuanwang on 11/5/16.
 */
public class MinimumEqualArray {
    public static int minEqualArray(int[] a){
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        while(a[0] != a[n-1]){

            for(int i = 0; i < n-1; i++){
                a[i]++;
            }
            if(a[n-2] > a[n - 1]) {
                int temp = a[n-2];
                a[n-2] = a[n-1];
                a[n-1] = temp;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        int[] a= {1,2,3};
        int res = minEqualArray(a);
        return;
    }
}
