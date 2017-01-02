package string;

/**
 * Created by xuanwang on 1/1/17.
 */
/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    public class Solution {
        public String shortestPalindrome(String s) {

            char []str = s.toCharArray();
            String rev = revert(str);
            int length = s.length();
            if ( length <= 1 )
                return s;

            if ( isPalindrome(s) ){
                return s;
            }

            for (int i=0; i < length; i++) {
                String a = rev.substring(i);
                String b = s.substring(0, length - i);
                if (a.equals(b)) {
                    return rev.substring(0, i) + s;
                }
            }
            return "";
        }

        private String revert( char [] s )  {
            if (s == null || s.length == 0){
                return "";
            }
            int len = s.length;

            char[] ret = new char[len];

            for (int i = 0; i < len; i++ )  {
                ret[i] = s[len - 1 - i];
            }

            return new String(ret);
        }

        private boolean isPalindrome(String s){
            int length = s.length();

            for (int i = 0, j = length - 1; i < j; i++, j-- ){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
            return true;
        }

    }


}
