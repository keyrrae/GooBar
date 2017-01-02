package Intervals;

import SortAndHeap.MeetingRoomsII;
import structures.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanwang on 1/1/17.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();

        Interval temp = newInterval;

        for(Interval interval: intervals){
            if(interval.end < temp.start){
                ans.add(interval);
            }else if(interval.start > temp.end){
                ans.add(temp);
                temp = interval;
            }else if(interval.start <= temp.end || interval.end >= temp.start){
                temp = new Interval(Math.min(interval.start, temp.start), Math.max(interval.end, temp.end));
            }
        }
        ans.add(temp);
        return ans;
    }
}
