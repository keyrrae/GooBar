package string;
import java.util.*;
/**
 * Created by xuanwang on 1/1/17.
 */
public class PalindromePairs {
    /*
    Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

    Example 1:
    Given words = ["bat", "tab", "cat"]
    Return [[0, 1], [1, 0]]
    The palindromes are ["battab", "tabbat"]

    Example 2:
    Given words = ["abcd", "dcba", "lls", "s", "sssll"]
    Return [[0, 1], [1, 0], [3, 2], [2, 4]]
    The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
    */

    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> ans = new HashSet<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }

        for (int i =0; i < words.length; i++){
            for (int j = 0; j <= words[i].length(); j++){
                String ls = words[i].substring(0,j);
                String rs = words[i].substring(j);

                if(isPalindrome(ls)){
                    String rsRev = reverse(rs);
                    if(map.containsKey(rsRev) && map.get(rsRev) != i){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(map.get(rsRev));
                        temp.add(i);

                        ans.add(temp);
                    }
                }

                if(isPalindrome(rs)){
                    String lsRev = reverse(ls);
                    if(map.containsKey(lsRev) && map.get(lsRev) != i){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(map.get(lsRev));
                        ans.add(temp);
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l : ans){
            res.add(l);
        }

        return res;
    }

    private String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left)!= s.charAt(right)){
                return false;
            }
            left++; right--;
        }
        return true;
    }
}
