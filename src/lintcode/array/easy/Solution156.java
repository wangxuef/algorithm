package lintcode.array.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Merge Intervals
// 合并区间

/*

	[                     [
	  [1, 3],               [1, 6],
	  [2, 6],      =>       [8, 10],
	  [8, 10],              [15, 18]
	  [15, 18]            ]
	]

 */
public class Solution156 {
    public List<Interval> merge(List<Interval> intervals) {
        
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        // 对intervals 排序
        Collections.sort(intervals, new IntervalComparator());
        
        List<Interval> result = new ArrayList<>();
        
        Interval last = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.start <= last.end){  // 有重合
                last.end = Math.max(last.end, cur.end);
            }else{
                result.add(last);
                last = cur;
            }
        }
        result.add(last);
        return result;
    }
    
    // 按照start 从小到大排序
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

}

// 区间
class Interval {
    int start;
    int end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}