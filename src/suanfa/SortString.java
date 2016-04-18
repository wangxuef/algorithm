package suanfa;

import java.util.Scanner;

// 华为编程题：字符串排序
/**
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则1：英文字母从A到Z排列，不区分大小写。如，输入：Type 输出：epTy
 * 规则2：同一个英文字母的大小写同时存在时，按照输入顺序排列。如，输入：BabA 输出：aABb
 * 规则3：非英文字母的其它字符保持原来的位置。如，输入：By?e 输出：Be?y
 * @author wxf
 */
public class SortString {
    
    /**
     * 先把字母链接起来，再插入其他字符
     * 连接字母的依据是遍历字母
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<25; i++){
                char c = (char)(i + 'a'); // 遍历26个字母
                for(int j=0; j<str.length(); j++){
                    char ch = str. charAt(j);
                    if(c == ch || c-32 == ch){
                        sb.append(ch);
                    }
                }
            }
            
            for(int i=0; i<str.length(); i++){
                char cha = str.charAt(i);
                if((cha>='a' && cha<='z') || (cha>='A' && cha<='Z')){
                    continue;
                }else{
                    sb.insert(i, cha);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
