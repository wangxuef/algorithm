package suanfa.mogujie;

import java.util.Scanner;

// 给定一个字符串，问是否能通过添加一个字母将其变为回文串
/**
 * @author wxf
 */
public class Palindromic {
    
    public static void main(String[] args) {
        run();
    }
    
    public static void run(){
        Scanner in = new Scanner(System.in);
        String str;
        String revStr;
        while(in.hasNext()){
            str = in.nextLine();
            revStr = reverse(str);
            if(isInsertPalindromic(str,revStr)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }   
    }
    /**
     * 判断是否是回文串
     * @param str
     * @param revStr
     * @return
     */
    public static boolean isInsertPalindromic(String str,String revStr){
        int low = 0;
        int high = str.length() - 1;
        if(low < high){
            while(low<= high && str.charAt(low) == revStr.charAt(low))
                low++;
            if(low==high + 1)// 本来就是回文串 添加一个字母也可以形成回文串
                return true;
            while(low<=high && str.charAt(high) == revStr.charAt(high))
                high--;
            if(high - low == 1) // 中间没有字母，只需增加一个就可以形成回文串
                return true;
            // 两个字符串比较出现不相等的情况，
            // str low-high-1 和 revStr low+1-high 部分是回文串则整体就是回文串
            String strTmp = str.substring(low,high);
            String revTmp = revStr.substring(low+1,high+1);
            if(isEqual(strTmp,revTmp))
                return true;
         // str low+1-high 和 revStr low-high-1 部分是回文串则整体就是回文串
            strTmp = str.substring(low+1,high+1);
            revTmp = revStr.substring(low,high);
            if(isEqual(strTmp,revTmp))
                return true;
        }
        return false;
    }
    
    /**
     * 判断两个字符串是否相等
     * @param a
     * @param b
     * @return
     */
    private static boolean isEqual(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        
        int low = 0;
        int high = a.length()-1;
        while(low<=high && a.charAt(low)==b.charAt(low)){
            low++;
        }
        if(low == high +1){
            return true;
        }
        return false;
    }
    
    /**
     * 字符串翻转
     * @param s
     * @return
     */
    private static String reverse(String s){
        String result = "";
        for(int i=s.length()-1; i>=0; i--){
            result += s.charAt(i);
        }
        return result;
    }
    
}
