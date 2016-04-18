package lintcode.array.medium;

// 买卖股票的最佳时机
/**
 * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
 * 如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
 * 
 * 给出一个数组样例 [3,2,3,1,2], 返回 1 
 */
public class Solution149m {
    
    public static void main(String[] args) {
        int[] a = {3,2,4,1,2};
        System.out.println(maxProfit2(a));
    }
    
    // 暴力 --时间复杂度O(N2)
    public static int maxProfit(int[] prices) {
        int max = 0;
    	for(int i=0; i<prices.length; i++){
    	    for(int j=i; j<prices.length; j++){
    	        max = Math.max(max, prices[j] - prices[i]);
    	    }
    	}
    	return max;
    }
    
    //动态规划，选取最小的买，最大的卖----时间复杂度O(N)
    public static int maxProfit2(int[] prices){
        if(prices==null || prices.length==0){
            return 0;
        }
        int minBuy = prices[0];
        int result = 0;
        for(int i=1;i<prices.length;i++){
            result = Math.max(result, prices[i]-minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }
        return result;
    }
    
}
