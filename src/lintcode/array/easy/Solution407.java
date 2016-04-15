package lintcode.array.easy;

//  Plus One
//Given [1,2,3] which represents 123, return [1,2,4].
//Given [9,9,9] which represents 999, return [1,0,0,0].

public class Solution407 {
    public int[] plusOne(int[] digits) {
        int carries = 1;
        for(int i=digits.length-1; i>=0 && carries>0; i--){
            int sum = digits[i] + carries;
            digits[i] = sum % 10; 
            carries = sum / 10; //进位
        }
        if(carries==0){ //加完最高位后，判断carries是否为0
            return digits;
        }
        // carries == 1
        int[] rst = new int[digits.length+1];
        rst[0] = 1;
        for(int i=1; i<rst.length; i++){
            rst[i] = digits[i-1];
        }
        return rst;
    }
    
}
