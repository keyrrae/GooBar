/**
 * Created by xuanwang on 11/9/16.
 */
//  ())) -> 3
//  (()) -> 4
public class ValidParenthesesParis {
    int numValidPairs(String s) {
        int res = 0, nLeft = 0; // number of '(' up to current index position.
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') nLeft++;
            else res += nLeft; // current char is ')' which can pair with any previous '('.
        }
        return res;
    }
}
