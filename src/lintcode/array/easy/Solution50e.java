package lintcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;

// 数组剔除元素后的乘积
/**
 * 给出A=[1, 2, 3]，返回 B为[6, 3, 2]
 */
public class Solution50e {
    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> rst = new ArrayList<>();
        for(int i=0; i<A.size(); i++){
            Long cur = 1L;
            for(int j=0; j<A.size(); j++){
                if(j==i)
                    continue;
                cur *= A.get(j);
            }
            rst.add(cur);
        }
        return rst;
    }

    public static void main(String[] args) {
        Integer[] a = { 1, 2, 3 ,4};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(a));
        System.out.println(productExcludeItself(A));
    }

}
