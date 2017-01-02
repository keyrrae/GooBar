package adhoc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanwang on 1/1/17.
 */

/*
iven two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        long num = (long)numerator;
        long den = (long)denominator;

        StringBuilder sb = new StringBuilder();
        sb.append((num > 0) ^ (den > 0) ? "-":"");

        num = Math.abs(num);
        den = Math.abs(den);

        sb.append(num/den);
        num %= den;

        if(num == 0){
            return sb.toString();
        }

        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while(num != 0){
            num *= 10;
            sb.append(num / den);
            num %= den;
            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }else{
                map.put(num, sb.length());
            }
        }
        return sb.toString();

    }
}
