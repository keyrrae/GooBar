package string;

/**
 * Created by xuanwang on 1/1/17.
 */
/*
Given a string which consists of lowercase or uppercase letters,
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] map = new int[256];

        for(char c: s.toCharArray()){
            map[c]++;
        }

        int maxOdd = 0, total = 0;
        for(int i =0; i <256; i++){
            if((map[i] & 1) == 1 && map[i] > maxOdd){
                maxOdd = map[i];
            } else if ((map[i] & 1) == 0){
                total += map[i];
            }
        }

        return total + maxOdd;

    }
}
