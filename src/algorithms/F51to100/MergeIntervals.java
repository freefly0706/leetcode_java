package algorithms.F51to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        /**
         * 将intervals按照start进行排序，然后进行合并
         */
        if (intervals.isEmpty()) {
            return new ArrayList<>();
        }
        List<Interval> res = new ArrayList<>();
        intervals.sort(new IntervalComparator());
        Interval contInterval = intervals.get(0);
        for (Interval interval : intervals) {
            if (interval.start <= contInterval.end) {
                contInterval.end = Math.max(interval.end, contInterval.end);
            } else {
                res.add(contInterval);
                contInterval = interval;
            }
        }
        res.add(contInterval);
        return res;
    }

    public static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    }

//    public List<Interval> merge(List<Interval> intervals) {
//        /**
//         * 分别取出intarvals的start和end，构成两个数组，分别对这
//         * 两个数组排序，之后从中提取interval
//         */
//        List<Interval> res = new ArrayList<>();
//        int intervalsSize = intervals.size();
//        int[] starts = new int[intervalsSize];
//        int[] ends = new int[intervalsSize];
//        int i = 0;
//        for (Interval interval : intervals) {
//            starts[i] = interval.start;
//            ends[i++] = interval.end;
//        }
//        Arrays.sort(starts);
//        Arrays.sort(ends);
//        i = 0;
//        for (int j = 0; j < intervalsSize; j++) {
//            if (j == intervalsSize - 1 || starts[j + 1] > ends[j]) {
//                res.add(new Interval(starts[i], ends[j]));
//                i = j + 1;
//            }
//        }
//        return res;
//    }
}
