package suanfa;

import java.util.HashMap;
import java.util.Stack;

// 表达式合法判断
/**
 * 判断一个包括'{','[','(',')',']','}'的表达式是否合法
 * @author wxf
 */
public class CheckExpression {
    // "[a+b*(5-4)]*{x+b+b*({1+2)}}"
    public static boolean check(String A) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        
        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);
            if(map.containsKey(ch)){ // 遇到左括号就入栈
                stack.push(ch);
            }else if(map.containsValue(ch)){ // 遇到右括号
                if(stack.isEmpty()){ // 栈为空，没有左括号。return false
                    return false;
                }
                char top = stack.peek(); 
                if(map.get(top).equals(ch)){ // 比较左右括号是否匹配
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String A = "[a+b*(5-4)]*{x+b+b*({1+2})}";
        String a = "[a+b*(5-4)]*{x+b+b*(({1+2)}}";
        System.out.println(check(a));
    }
}
