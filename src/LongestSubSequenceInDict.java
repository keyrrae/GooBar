import java.util.*;
import java.util.stream.Collector;

/**
 * Created by xuanwang on 11/9/16.
 */
public class LongestSubSequenceInDict {
    public static int getLongest(String s, String[] arr){
        Arrays.sort(arr, (a, b) -> b.length()- a.length());

        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            map.putIfAbsent(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }
        //apdfenipfenile apple

        for(int i = 0; i < arr.length; i++){
            String cur = arr[i];
            Map<Character, Integer> lastSeen = new HashMap<>();
            int idx = -1;
            boolean found = true;
            for(int j = 0; j < cur.length();j++){
                char c = cur.charAt(j);
                if(!map.containsKey(c)){
                    found = false;
                    break;
                }
                if(!lastSeen.containsKey(c)){
                    lastSeen.put(c, -1);
                }
                int pos = lastSeen.get(c)+1;
                if(pos > map.get(c).size()-1){
                    found = false;
                    break;
                }
                while(pos < map.get(c).size() && map.get(c).get(pos) <= idx){
                    pos++;
                }
                idx = map.get(c).get(pos);
                lastSeen.put(c, pos);
            }
            if(found){
                return cur.length();
            }
        }
        return 0;
    }

    public static void main(String[] args){
        String s = "apppppppfenile";
        String[] dict = {"ale", "apple", "apd"};
        int res = getLongest(s, dict);
        System.out.println("hello");
    }
}
