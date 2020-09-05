class MergeIntervals {
   /*
   *
   * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
   * You may assume that the intervals were initially sorted according to their start times.
   *
   * Solution taken from interviewbit
   * */

   /* https://www.interviewbit.com/problems/merge-intervals */
   public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
       Interval current = newInterval;
       int i=0;
       while(i< intervals.size()) {
           Interval interval = intervals.get(i);
           if(interval.end < current.start) i++;
           else if(interval.start > current.end) {
               intervals.add(i, current);
               break;
           } else {
               current.start = Math.min(current.start, interval.start);
               current.end = Math.max(current.end, interval.end);
               intervals.remove(i);
           }
       }

       if(i == intervals.size()) {
           intervals.add(current);
       }

       return intervals;

   }

    private MergeIntervals() {
    }

}