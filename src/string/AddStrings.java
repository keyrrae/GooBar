package string;

/**
 * Created by xuanwang on 1/1/17.
 */
public class AddStrings {
    public String addStrings(String s, String t) {
        int len1=s.length()-1;
        int len2=t.length()-1;

        StringBuilder sb=new StringBuilder();
        int sum=0,carry=0;
        while(len1>=0 || len2>=0) {
            int first=len1>=0?s.charAt(len1)-'0':0;
            int second=len2>=0?t.charAt(len2)-'0':0;
            sum=carry+first+second;
            sb.append(sum%10);
            carry = sum/10;
            len1--;
            len2--;
        }
        if(carry!=0)sb.append(carry);
        return sb.reverse().toString();
    }
}
