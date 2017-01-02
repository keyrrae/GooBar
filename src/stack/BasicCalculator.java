package stack;

import java.util.LinkedList;

/**
 * Created by xuanwang on 1/1/17.
 */
public class BasicCalculator {
    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        String t = s.replace("\\s+", "");
        int res = 0;
        int sgn = 1;
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i + 1< s.length() && Character.isDigit(s.charAt(i + 1))){
                    i++;
                    num = num * 10 + s.charAt(i) - '0';
                    //System.out.printf("%c\n", c);
                }
                res += sgn * num;
            }else if(c == '+'){
                sgn = 1;
            }else if(c == '-'){
                sgn = -1;
            }else if(c == '('){
                stack.push(res);
                stack.push(sgn);
                res = 0;
                sgn = 1;
            }else if(c == ')'){
                res = stack.pop() * res + stack.pop();
                sgn = 1;
            }
        }
        return res;
    }
}
