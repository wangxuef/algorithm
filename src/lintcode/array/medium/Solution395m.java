package lintcode.array.medium;

// 硬币排成线II
/**
 * 有 n 个不同价值的硬币排成一条线。两个参赛者轮流从左边依次拿走 1 或 2 个硬币，直到没有硬币为止。
 * 计算两个人分别拿到的硬币总价值，价值高的人获胜。
 * 请判定 第一个玩家 是输还是赢？
 * @author Administrator
 */

public class Solution395m {
    public boolean firstWillWin(int[] values) {
        // write your code here
        // dp 表示从i到end 的最大值
        // int values[] ={1,2,4,3,4,8,5,6,12};
        int len = values.length;
        // 长度小于2的时候第一个人一定获胜
        if(len <= 2)
            return true;
        int dp[] = new int[len+1];
        dp[len] = 0;
        dp[len-1] = values[len-1];
        dp[len-2] = values[len-1] + values[len - 2];
        dp[len - 3] = values[len-3] + values[len - 2];
        for(int i = len -4;i>=0;i--){
            dp[i] = values[i] + Math.min(dp[i+2],dp[i+3]);
            dp[i] = Math.max(dp[i],values[i]+values[i+1]+ Math.min(dp[i+3],dp[i+4]));

        }
        int sum = 0;
        for(int a:values)
            sum +=a;
        return dp[0] > sum - dp[0];
    }
    
}
