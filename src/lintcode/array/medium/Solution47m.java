package lintcode.array.medium;

import java.util.ArrayList;
/**
 * 主元素II---它在数组中的出现次数严格大于数组元素个数的三分之一。
 * 挑战---要求时间复杂度为O(n)，空间复杂度为O(1)
 * 
 * 可以用HashMap。但是 时间、空间复杂度都是O(n)
 */
public class Solution47m {
    /**
     * 如果出现3个不一样的数，就抵消掉。
     * 记录两个candidate和每个candidate分别的出现次数。如果遍历到的数和两个candidate都不等，就count都减1。
     * 最后可能会剩下两个candidate，再遍历一次整个数组验证一下谁是主元素
     * @param nums
     * @return
     */
    public int majorityNumber(ArrayList<Integer> nums){
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
}
