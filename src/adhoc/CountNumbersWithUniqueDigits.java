package adhoc;
/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91.
(The answer should be the total numbers in the range of 0 ≤ x < 100,
excluding [11,22,33,44,55,66,77,88,99])
 */
/**
 * Created by xuanwang on 1/1/17.
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int ans = 10, part = 9;
        for(int i = 2; i<= n && i<=10;i++){
            part = part * (9-i+2);
            ans += part;
        }
        return ans;
    }
}
