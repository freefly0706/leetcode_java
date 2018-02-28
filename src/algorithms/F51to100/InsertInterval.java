package algorithms.F51to100;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int size = intervals.size();
        int i = 0;
        for (; i < size && intervals.get(i).end < newInterval.start; i++) {
            res.add(intervals.get(i));
        }
        if (i < size) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            for (; i < size && intervals.get(i).start <= newInterval.end; i++) ;
            if (i > 0) {
                newInterval.end = Math.max(newInterval.end, intervals.get(i - 1).end);
            }
        }
        res.add(newInterval);
        res.addAll(intervals.subList(i, size));
        return res;
    }
}
