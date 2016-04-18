package suanfa;

// 产生n位元的所有格雷码
import java.util.Arrays;
/**
 * 原始的值从0开始,格雷码产生的规律是：第一步，改变最右边的位元值；第二步，改变右起第一个为1的位元的左边位元；第三步，第四步重复第一步和第二步，直到所有的格雷码产生完毕.
 * 假设产生3位元的格雷码，原始值位                         000
 * 第一步：改变最右边的位元值：                                001
 * 第二步：改变右起第一个为1的位元的左边位元： 011
 * 第三步：改变最右边的位元值：                                010
 * 第四步：改变右起第一个为1的位元的左边位元： 110
 * 第五步：改变最右边的位元值：                                111
 * 第六步：改变右起第一个为1的位元的左边位元： 101
 * 第七步：改变最右边的位元值：                                100
 * 
 * 
 * 除了最高位（左边第一位），格雷码的位元完全上下对称(上面四个和下面四个对称）。比如第一个格雷码与最后一个格雷码对称（除了第一位），第二个格雷码与倒数第二个对称，以此类推。
 * 
 * n位元格雷码是基于n-1位元格雷码产生的。。。。。。。。。。。。。。。
 * @author wxf
 */
public class GrayCode {
    public static String[] getGray(int n) {
        String[] grayCode = new String[(int)Math.pow(2, n)];
        
        if(n==1){
            grayCode[0] = "0";
            grayCode[1] = "1";
            return grayCode;
        }
        
        String[] last = getGray(n-1);
        
        for(int i=0; i<last.length; i++){
            //grayCode[i]和 grayCode[grayCode.length-1-i] 在加"0","1"之前对称
            grayCode[i] = "0" + last[i];
            grayCode[grayCode.length-1-i] = "1" + last[i];
        }
        
        return grayCode;

    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getGray(3)));
    }
}
