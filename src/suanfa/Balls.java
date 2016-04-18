package suanfa;

// 抛小球
/**
 * 小东和三个朋友一起在楼上抛小球，他们站在楼房的不同层，假设小东站的楼层距离地面N米，
 * 球从他手里自由落下，每次落地后反跳回上次下落高度的一半，并以此类推直到全部落到地面不跳，求4个小球一共经过了多少米？
 * 
 * @author wxf
 */
public class Balls {
    public static int calcDistance(int A, int B, int C, int D) {
        double result = 0.0;
        result = getDistance(A) + getDistance(B) + getDistance(C) + getDistance(D);
        return (int)result;
    }
    
    private static double getDistance(double n){
        if(n==0)
            return 0;
        return n+n/2+getDistance(n/2);
    }
    
    public static void main(String[] args) {
        System.out.println(calcDistance(2,5,3,1));
    }
    
}

/**
 * 3*（A+B+C+D）
 */
