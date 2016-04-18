package suanfa;
//字符替换
/**
 * 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",
 * 请按照参数列表的顺序一一替换占位符。若参数列表的字符数大于占位符个数。
 * 则将剩下的参数字符添加到字符串的结尾。
 * 
 * "A%sC%sE",['B','D','F']
 * 返回："ABCDEF"
 * @author Administrator
 *
 */
public class StringFormat {
    public static String formatString(String A, char[] arg) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = 0; i < A.length();) {
            if ('%' == A.charAt(i)) {
                sb.append(arg[k++]);
                i += 2;
            } else {
                sb.append(A.charAt(i));
                i++;
            }
        }
        while (k < arg.length) {
            sb.append(arg[k++]);
        }
        return sb.toString();
    }

    public static String formatString2(String A, char[] arg) {
        // StringBuilder sb = new StringBuilder();
        int i = 0;
        int k = 0;
        while (A.indexOf("%s") >= 0) {
            A = A.replaceFirst("%s", "" + arg[k++]);
        }
        while (k < arg.length) {
            A += arg[k++];
        }
        return A;
    }

    public static void main(String[] args) {
        String a = "A%sCE";
        char[] aa = { 'B', 'D', 'F' };

        System.out.println(formatString2(a, aa));
    }
}
