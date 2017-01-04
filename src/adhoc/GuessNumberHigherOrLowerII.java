package adhoc;

/**
 * Created by xuanwang on 1/1/17.
 */

/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x.
You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */

public class GuessNumberHigherOrLowerII {
    /*
    For each number x in range[i~j]
we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
--> // the max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse branch.
then we get DP([i~j]) = min{xi, ... ,xj}
--> // this min makes sure that you are minimizing your cost.
     */
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        for(int j=2; j<=n; j++){
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i+1==j?i:globalMin;
            }
        }
        return table[1][n];
    }

    public int getMoneyAmountii(int n) {
        if(n==1)return 0;
        int[][] dp = new int[n+1][n+1];

        for(int jmi = 1 ;jmi < n;jmi++){
            for(int i = 0; i+ jmi <=n; i++){
                int j = i + jmi;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(k-1>=i?dp[i][k-1]:0, k+1<=j?dp[k+1][j]:0) + k);
                }
            }
        }
        return dp[1][n];
    }
}
