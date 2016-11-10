import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanwang on 11/9/16.
 */
public class ComeLeave {
    public static List<Character> getLeft(List<Character> a, List<Character> b){
        Set<Character> set = new HashSet<>();
        Set<Character> res = new HashSet<>();
        for(char c: a){
            set.add(c);
        }
        for(char c: b){
            if(set.contains(c)){
                set.remove(c);
            }else{
                res.add(c);
            }
        }
        return new ArrayList<Character>(res);
    }

    public static void main(String[] args){
        List<Character> a = new ArrayList<>();
        List<Character> b = new ArrayList<>();
        a.add('a');a.add('b');a.add('c');
        b.add('c');b.add('b');b.add('d');
        List<Character> ans = getLeft(a, b);
        System.out.println("Hello");
    }
}
