package adhoc;

/**
 * Created by xuanwang on 12/31/16.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;

        int[] a = new int[len+1];
        for(int c: citations){
            if(c > len){
                a[len]++;
            }else{
                a[c]++;
            }
        }

        int sum = 0;
        for(int i = len; i >= 0; i--){
            sum += a[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}
