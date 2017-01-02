package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanwang on 1/1/17.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }

        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });


        helper(ans, "", digits, 0, map);

        return ans;
    }

    private void helper(List<String> ans, String path, String digits, int pos, Map<Character, char[]> map) {
        if (path.length() == digits.length()) {
            ans.add(path);
            return;
        }

        for (char c : map.get(digits.charAt(pos))) {
            helper(ans, path + c, digits, pos+1, map);
        }
    }
}
