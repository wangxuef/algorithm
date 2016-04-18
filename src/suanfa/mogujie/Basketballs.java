package suanfa.mogujie;

import java.util.Scanner;

//投篮游戏
/**
 * 有一个投篮游戏。球场有p个篮筐，编号为0，1...，p-1。每个篮筐下有个袋子，每个袋子最多装一个篮球。有n个篮球，每个球编号xi。
 * 规则是将数字为xi的篮球投到xi除p的余数为编号的袋里。若袋里已有篮球则球弹出游戏结束输出i，否则重复至所有球都投完。输出-1。问游戏最终的输出是什么？
 * 
 * 输入描述:
 * 第一行两个整数p,n（2≤p,n≤300)。p为篮筐数，n为篮球数。接着n行为篮球上的数字xi(0≤xi≤1e9)
 * @author wxf
 */
public class Basketballs {
    
    public static void main(String[] args) {
        Basketballs b = new Basketballs();
        b.run();
    }
    
    int p, n;
    int A[];
    int X[];
    int id;
    public void run(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            p = sc.nextInt(); // p个篮筐
            n  = sc.nextInt(); // n个篮球
            A = new int[p]; 
            X = new int[n];
            for(int i=0; i<n; i++){
                X[i] = sc.nextInt(); // 篮球上编号
            }
            id = judge(A, X);
            System.out.println(id);
        }   
    }
    
    public int judge(int[] A, int[] X){
        for(int i=0; i<X.length; i++){
            int id = X[i]%p;
            if(id>=p){
                return -1;
            }
            if(A[id] == 0){
                A[id] = 1;
            }else {
                return i+1;
            }
        }
        return -1;
    }
    
}
