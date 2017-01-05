package structures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanwang on 12/23/16.
 */
public class UniqueWordAbbreviation {
    public class ValidWordAbbr {
        //Abbreviation, word
        Map<String, String> map;
        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();

            for(String s: dictionary){
                String key = getKey(s);
                if(map.containsKey(key) && !map.get(key).equals(s)){
                    map.put(key, "");
                }else{
                    map.put(key, s);
                }
            }
        }

        public boolean isUnique(String word) {
            String key = getKey(word);

            if( !map.containsKey(key) || map.get(key).equals(word)) return true;
            return false;
        }

        private String getKey(String word){
            if(word.length() <= 2) return word;
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0)); sb.append(word.length()-2); sb.append(word.charAt(word.length()-1));
            return sb.toString();
        }
    }


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
}
