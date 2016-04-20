package lintcode.array.easy;

// 数字三角形
/**
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 * @author wxf
 */
public class Solution109e {
    
    // 从上往下走
    public int minimumTotal2(int[][] triangle){
        if(triangle.length==1 && triangle[0].length==1)
            return triangle[0][0];
        
        int min = Integer.MAX_VALUE;
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0){ // 左边界
                    triangle[i][j] += triangle[i-1][j];
                }else if(j == triangle[i].length-1){ //右边界
                    triangle[i][j] += triangle[i-1][j-1];
                }else { 
                    triangle[i][j] += Math.min(triangle[i-1][j-1], triangle[i-1][j]);
                }
                if(i==triangle.length-1){ // 最下一行，遍历取最小值
                    min = Math.min(min, triangle[i][j]);
                }
            }
        }
        return min;
    }
    
    // 从下往上走-------不用管边界
    public int minimumTotal(int[][] triangle) {
        if(triangle.length==1 && triangle[0].length==1)
            return triangle[0][0];
        
        int minnum = Integer.MAX_VALUE;
        for(int i=triangle.length-2;i>=0;i--){
            for(int j=0;j<triangle[i].length;j++){
                triangle[i][j] += Math.min(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        minnum = triangle[0][0];
        return minnum;
    }
}
