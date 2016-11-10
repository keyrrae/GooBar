import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanwang on 11/1/16.
 */
public class QuoteSplit {
    public enum State{
        NORMAL, QUOTE
    }

    public static List<String> quoteSplit(String s){
        List<String> ans = new ArrayList<>();
        if(s == null || s.length() == 0) return ans;

        StringBuilder sb = new StringBuilder();
        State state = State.NORMAL;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (state){
                case NORMAL:
                    switch (c){
                        case ' ':
                            if(sb.length() != 0){
                                ans.add(sb.toString());
                                sb.setLength(0);
                            }
                            break;
                        case '"':
                            state = State.QUOTE;
                            break;
                        default:
                            sb.append(c);
                    }
                    break;
                case QUOTE:
                    switch (c){
                        case '"':
                            ans.add(sb.toString());
                            sb.setLength(0);
                            state = State.NORMAL;
                            break;
                        default:
                            sb.append(c);
                    }
                    break;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        String s = "  fdf  safioe  \"asfoe fewab\"jiowafhoiewa fewhaoifheawoi";
        System.out.println(quoteSplit(s));
    }
}
