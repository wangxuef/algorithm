package lintcode.array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 主元素---给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 * 挑战---要求时间复杂度为O(n)，空间复杂度为O(1)
 * @author wxf
 */

/**
 * 主元素II---它在数组中的出现次数严格大于数组元素个数的三分之一。
 * 挑战---要求时间复杂度为O(n)，空间复杂度为O(1)
 * 
 * 可以用HashMap。但是 时间、空间复杂度都是O(n)
 */

public class Solution46e {
    // 抵消法。
    /**
     * 一旦发现数组中存在两个不同的数，就都删除，直到剩下的数都一样。此时剩下的数就是主元素。因为每次抵消操作之后，剩下来的数种，主元素一定也还是超过一半的。
     * 
     * 具体实现的时候，记录一个candidate和其出现的次数count，遍历每个数，
     * 如果count==0，则把candidate置为遍历到的数，否则看遍历到的数和candidate是否相等，
     * 如果相等，则count++，否则count--（抵消），遍历结束后，candidate就是主元素。
     * @param nums
     * @return 主元素
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 0;
        int cur = nums.get(0);
        for(int i=0; i<nums.size(); i++){
            if(count == 0){   // 重新记录
                cur = nums.get(i);
                count = 1;
            }else{  //潜在主元素
                if(cur == nums.get(i)){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return cur;
    }
    
    // 用HashMap，时间、空间复杂度都是O(n)
    public int majorityNumber_Map(ArrayList<Integer> nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.size(); i++){
            int num = nums.get(i);
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
            if(map.get(num)>nums.size()/2){
                return num;
            }
        }
        return 0;
    }
    
    
    // 主元素II
    /**
     * 如果出现3个不一样的数，就抵消掉。
     * 记录两个candidate和每个candidate分别的出现次数。如果遍历到的数和两个candidate都不等，就count都减1。
     * 最后可能会剩下两个candidate，再遍历一次整个数组验证一下谁是主元素
     * @param nums
     * @return
     */
    public int majorityNumber_II(ArrayList<Integer> nums){
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int time1=0, time2=0;
        for(int i=0; i<nums.size(); i++){
            int num = nums.get(i);
            if(num == num1){ //等于第一个candidate
                time1++;
            }else if(num == num2){ //等于第二个candidate
                time2++;
            }else if(time1==0){// 出现3个不同的数（与2个candidate都不等）
                time1=1;
                num1=num;
            }else if(time2==0){
                time2=1;
                num2=num;
            }else{ // 出现3个不同的数（与2个candidate都不等）。并且time1，time2都不等于0
                time1--;
                time2--;
            }
        }
        
        //可能会剩下两个candidate
        time1=0;
        time2=0;
        for(int i=0; i<nums.size(); i++){
            int num = nums.get(i);
            if(num==num1){
                time1++;
            }else if(num==num2){
                time2++;
            }
        }
        return time1>time2?num1:num2;
    }
    
    
    
    
    
    
    
    
    
    //法一：O(32n)位操作。统计32位每一位1的个数多还是0的个数多，取个数多的为该位结果值。-----？？？？？
    public int majorityNumber2(ArrayList<Integer> nums) {
        int bit = 1;
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int count0 = 0;
            int count1 = 0;
            for(int j = 0; j < nums.size(); j++) {
                if((nums.get(j) & bit) == bit) {//第i位为1
                    count1++;
                }else {//第i位为0
                    count0++;
                }
            }
            if(count0 < count1){//第i位1的数目多于0的数目，则该位应为1，否则为0
                result = result ^ bit;
            }
            bit = bit<<1;
        }
        return result;
    }
    
}
