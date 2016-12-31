package adhoc;

/**
 * Created by xuanwang on 12/23/16.
 */
public class UnionCode {
    public boolean validUtf8(int[] data) {
        if(data==null || data.length==0) return false;
        boolean isValid = true;
        int i = 0;
        while(i < data.length) {
            if(data[i]>0xFF) return false;
            int numberOfBytes = 0;
            if((data[i] & 0x80) == 0) { // 0xxxxxxx, 1 byte, 0x80(10000000)
                numberOfBytes = 1;
            } else if((data[i] & 0xE0) == 0xC0) { // 110xxxxx, 2 bytes, 0xE0(11100000), 0xC0(11000000)
                numberOfBytes = 2;
            } else if((data[i] & 0xF0) == 0xE0) { // 1110xxxx, 3 bytes, 0xF0(11110000), 0xE0(11100000)
                numberOfBytes = 3;
            } else if((data[i] & 0xF8) == 0xF0) { // 11110xxx, 4 bytes, 0xF8(11111000), 0xF0(11110000)
                numberOfBytes = 4;
            } else {
                return false;
            }
            for(int j=1;j<numberOfBytes;j++) { // check that the next n bytes start with 10xxxxxx
                if(i+j>=data.length) return false;
                if((data[i+j] & 0xC0) != 0x80) return false; // 0xC0(11000000), 0x80(10000000)
            }
            i=i+numberOfBytes;
        }
        return isValid;
    }
}
