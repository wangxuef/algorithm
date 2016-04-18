package suanfa;

// 模式匹配---KMP算法
/**
 * 有一个文本串S，和一个模式串P，要查找P在S中的位置
 * @author Administrator
 */
public class StringMatch {
    
    /**
     * 暴力匹配
     * 如果当前字符匹配成功（即S[i] == P[j]），则i++，j++，继续匹配下一个字符；
     * 如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0。相当于每次匹配失败时，i 回溯，j 被置为0。
     * @param str
     * @param pattern
     * @return
     */
    public static int violentMatch(String str, String pattern) {
        int sLen = str.length();
        int pLen = pattern.length();
        int i = 0;
        int j = 0;

        while (i < sLen && j < pLen) {
            if (str.charAt(i) == pattern.charAt(j)) {
                // (1) 当两个字符匹配成功 即S[i] == P[j]） i++ j++
                i++;
                j++;
            } else {
                // (2) 如果失配 即S[i]! = P[j] ，令i = i - (j - 1) i 回到这次匹配开始的下一个位置
                i = i - (j - 1);
                j = 0;
            }
        }

        if (j == pLen) { // 匹配成功 j 等于 pattern的长度，返回匹配字符串的第一个位置
            return i - j;
        } else {
            return -1;
        }
    }
    
    //TODO KMP

    public static void main(String[] args) {
        String str = "asfasfhkgl;j;ahsfiabcdasdfasfl;ji";
        String pattern = "fasf";
        System.out.println(violentMatch(str, pattern));
    }
}
