package lintcode.array.easy;

import java.util.ArrayList;
import java.util.HashMap;

// 子数组之和
/**
 * 给定一个整数数组，找到和为零的子数组。返回满足要求的子数组的起始位置和结束位置 
 * 返回的是索引！！！
 * 
 * 给出 [-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3].
 */

public class Solution138e {
    
    // 暴力 超时 O(n3)
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return rst;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rst.add(i);
                rst.add(i);
                return rst;
            }
            
            for (int j = i + 1; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum == 0) {
                    rst.add(i);
                    rst.add(j);
                    return rst;
                }
            }
        }
        return rst;
    }

    // O(n2)
    public ArrayList<Integer> subarraySum2(int[] nums) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return rst;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rst.add(i);
                rst.add(i);
                return rst;
            }
            
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    rst.add(i);
                    rst.add(j);
                    return rst;
                }
            }
        }
        return rst;
    }

    // O(n)------HashMap
    public ArrayList<Integer> subarraySum3(int[] nums) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return rst;
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hash.containsKey(sum)) { // 说明之前的sum与现在的sum之间的那些数的和为0
                rst.add(hash.get(sum) + 1);
                rst.add(i);
                return rst;
            }
            hash.put(sum, i);
        }
        return rst;
    }

}
