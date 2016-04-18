package suanfa;

import java.util.ArrayList;

// 2016去哪儿编程题：文本嗅探
/**
 * 现在有一个字符串列表，和一个关键词列表，请设计一个高效算法，检测出含关键字列表中关键字(一个或多个)的字符串。
 * 
 * @author wxf
 */
public class KeywordDetect {


    public int[] containKeywords(String[] A, String[] keys){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<A.length; i++){
            boolean flag = isContains(A[i], keys);
            if(flag==true){
                list.add(i);
            }
        }
        
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        
        if(list.size() == 0){
            return new int[]{-1};
        }
        return result;
    }
    
    
    /**
     * str 中的子串是否在keys中存在
     * @param str
     * @param keys 关键词
     * @return
     */
    private boolean isContains(String str, String[] keys){
        int id = -1;
        for(int i=0; i<keys.length; i++){
            id = str.indexOf(keys[i]);
            if(id!=-1){
                return true;
            }
        }
        return false;
    }
    
}
