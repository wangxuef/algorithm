package lintcode.array.easy;

import java.util.ArrayList;

// 插入区间
/*
	给出一个无重叠的按照区间起始端点排序的区间列表。
	在列表中插入一个新的区间，你要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
	
	插入区间[2, 5] 到 [[1,2], [5,9]]，我们得到 [[1,9]]。
	插入区间[3, 4] 到 [[1,2], [5,9]]，我们得到 [[1,2], [3,4], [5,9]]。
*/
public class Solution30e {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> rst = new ArrayList<>();
        if(intervals==null ||intervals.size()<=0){
            rst.add(newInterval);
            return rst;
        }
        
        int insertPos = 0;
        for(int i=0; i<intervals.size(); i++){
            Interval curt = intervals.get(i);
            // 分三种情况！！！
            if(curt.end < newInterval.start){
                rst.add(curt);
                insertPos++;
            }else if(curt.start>newInterval.end){
                rst.add(curt);
            }else{
                newInterval.start = Math.min(curt.start, newInterval.start);
                newInterval.end = Math.max(curt.end, newInterval.end);
            }
        }
        rst.add(insertPos, newInterval);
        return rst;
    }
    
}
