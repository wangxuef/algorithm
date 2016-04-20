package lintcode.array.easy;

//爬楼梯
/**
 * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 * 
 */
public class Solution111 {
    // DP
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int last = 1;
        int lastlast = 1;
        int now = 0;

        for (int i = 2; i <= n; i++) {
            now = lastlast + last;
            lastlast = last;
            last = now;
        }

        return now;
    }

    // 递归 会超时
    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

}
