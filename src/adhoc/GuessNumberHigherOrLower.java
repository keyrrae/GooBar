package adhoc;

/**
 * Created by xuanwang on 1/1/17.
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int start = 1, end = n;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid)==-1){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(guess(start) == 0){
            return start;
        }

        if(guess(end) == 0){
            return end;
        }

        return -1;
    }
    int guess(int i){
        return 0;
    }
}
