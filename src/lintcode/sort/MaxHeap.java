package lintcode.sort;

//http://www.cnblogs.com/skywang12345/p/3610390.html

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉堆(最大堆)
 * @author wxf
 */
public class MaxHeap<T extends Comparable<T>> {
    private List<T> mHeap;
    public MaxHeap(){
        this.mHeap = new ArrayList<T>();
    }
    
    /**
     * 最大堆的向下调整算法
     * 第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)
     * @param start 被下调节点的起始位置(一般为0，表示从第1个开始)
     * @param end 截至范围(一般为数组中最后一个元素的索引)
     */
    private void filterdown(int start, int end){
        int current = start;
        int left = 2*current + 1;
        T tmp = mHeap.get(current);
        
        while(left <= end){
            // 比较左孩子、右孩子。选择较大的
            int cmp = mHeap.get(left).compareTo(mHeap.get(left+1));
            if(left<end && cmp<0){ //选择较大的
                left++; 
            }
            // 比较current和孩子
            cmp = mHeap.get(left).compareTo(tmp);
            if(cmp<=0){ // current > 孩子
                break; // 调整结束
            }else {
                mHeap.set(current, mHeap.get(left));
                current = left;
                left = 2*current+1;
            }
        }
        mHeap.set(current, tmp);
    }
    
    /**
     * 删除最大堆中的data
     * @param data
     * @return  0：成功，-1：失败
     */
    public int remove(T data){
        if(mHeap.isEmpty()){
            return -1;
        }
        
        int index = mHeap.indexOf(data);
        if(index==-1){
            return -1;
        }
        
        int size = mHeap.size();
        mHeap.set(index, mHeap.get(size-1));// 用最后元素填补
        mHeap.remove(size-1);
        
        if(mHeap.size()>1){
            filterdown(index, mHeap.size()-1);
        }
        
        return 0;
    }
    
    /**
     * 最大堆的向上调整算法
     * @param start 被上调节点的起始位置(一般为数组中最后一个元素的索引)
     */
    private void filterup(int start){
        int current = start;
        int parent = (current-1)/2;
        T tmp = mHeap.get(current);
        
        while(current>0){
            int cmp = mHeap.get(parent).compareTo(tmp);
            if(cmp>=0){
                break;
            }else {
                mHeap.set(current, mHeap.get(parent));
                current = parent;
                parent = (current-1)/2;
            }
        }
        mHeap.set(current, tmp);
    }
    
    /**
     * 将data插入到二叉堆中
     * @param data
     */
    public void insert(T data){
        int size = mHeap.size();
        mHeap.add(data);
        filterup(size);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mHeap.size(); i++)
            sb.append(mHeap.get(i) + " ");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
        MaxHeap<Integer> tree = new MaxHeap<Integer>();
        
        for(int i=0; i<a.length; i++){
            tree.insert(a[i]);
        }
        
        System.out.println("maxHeap:" + tree.toString());
        
        tree.insert(85);
        System.out.println("maxHeap:" + tree.toString());
        
        tree.remove(90);
        System.out.println("maxHeap:" + tree.toString());
        
    }
}
