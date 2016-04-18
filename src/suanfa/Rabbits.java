package suanfa;

import java.util.Scanner;

// 兔子藏洞
/**
 * 一只兔子藏身于20个圆形排列的洞中（洞从1开始编号），一只狼从x号洞开始找,下次隔一个洞找(及在x＋2号洞找)，
 * 再下次隔两个洞找(及在x＋5号洞找)，以此类推。。。它找了n次仍然没有找到。问兔子可能在那些洞中。
 * 
 * 输入描述:输入有多组数据，每组数据一行两个整数分别为x和n(x <= 20,n <= 100000)
 * 
 * 输出描述:每组数据一行按从小到大的顺序输出兔子可能在的洞，数字之间用空格隔开。若每个洞都不可能藏着兔子，输出-1。
 * 
 * @author wxf
 */
public class Rabbits {
    /**
     * 直接暴力，检测过的位置不可能有兔子，剩余的位置就是可能的位置
     * 检测洞的序列是：0 2 5 9，数组就是 an = an-1 + n
     * 同时洞的圆形的，要对20求余数，当是0的时候就是20号洞了
     */
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
       // ArrayList<Integer> list = new ArrayList<Integer>();
        int[] A;
        int x,n;
        int a1=0,a2=0;
        int id=0;
        boolean flag = true;
        while(in.hasNext()){
            x = in.nextInt();
            n = in.nextInt();  //找n次
            A = new int[21];
            
            for(int i = 1;i<= n;i++){
                if(i == 1){
                    a1 = 0;
                    id = (a1 + x);
                   
                }else{
                    a2 = a1 + i;
                    a1 = a2;
                    id = (a2 + x);
                }
                if (id % 20 == 0) // 0 转换成 20 号
                    id = 20;
                else
                    id = id % 20;
                A[id] = -1;
            }
            for(int i = 1;i<= 20;i++){
                if(A[i] ==0){
                    flag = false;
                    System.out.print(i+" ");
                }
            }
            if(flag)
                System.out.println(-1);
            else
                System.out.println();
        }
    }
    
}
