package suanfa;

// 产生n位元的所有格雷码
/**
 * 小东分苹果
 * 果园里有一堆苹果，一共n头(n大于1小于9)熊来分，第一头为小东，它把苹果均分n份后，多出了一个，它扔掉了这一个，拿走了自己的一份苹果，
 * 接着第二头熊重复这一过程，即先均分n份，扔掉一个然后拿走一份，以此类推直到最后一头熊都是这样(最后一头熊扔掉后可以拿走0个，也算是n份均分)。
 * 问最初这堆苹果最少有多少个。
 * 
 * 给定一个整数n,表示熊的个数，返回最初的苹果数。保证有解。
 * @author wxf
 */
public class Apples {
    public static int getInitial(int n) {
        
        // i 为第一个人得到的苹果，从0开始遍历。 
        for(int i=0; ; i++){
            int apple = i*n+1;//第一个人分苹果时共有( i * n+1)个苹果, 满足除以 n 余 1
            /**
             * 对第二个人分时候的苹果总数是： apple/n * (n - 1) ----- 因为一共n份，第一个人拿走一份。剩下n-1份就是第二个人分之前的苹果总数。
             * 同样也要除以 n 余 1 ，下面循环判断  n个人都要满足这个条件
             */
            int t = apple;
            boolean flag = true;
            for(int j=n; j>0; j--){
                if(t%n==1){
                    t=t/n * (n-1);
                }else {
                    flag = false;
                    break; // 第j个人不满足分苹果条件。跳出，接着试试 i+1 是不是能满足条件。
                }
            }
            if(flag ==  true){ // n 个人都满足条件, i 成立！！
                System.out.println(i); 
                return apple;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(getInitial(3));
    }
}
