package adhoc;

/**
 * Created by xuanwang on 1/1/17.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        if(n == Integer.MIN_VALUE) return false;
        return (n & (n - 1)) == 0;
    }
}
