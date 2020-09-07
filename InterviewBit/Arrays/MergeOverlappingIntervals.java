class MergeOverlappingIntervals {
   /*
   *
   * Given a collection of intervals, merge all overlapping intervals.
   * For example:
   * Given [1,3],[2,6],[8,10],[15,18],
   * return [1,6],[8,10],[15,18].
   * Make sure the returned intervals are sorted.
   * */

   /* https://www.interviewbit.com/problems/merge-overlapping-intervals */
   ArrayList<Interval> merge(ArrayList<Interval> intervals) {
       Collections.sort(intervals, new Comparator<Interval>(){

           @Override
           public int compare(Interval i1, Interval i2) {
               return i1.start-i2.start;
           }
       });

       ArrayList<Interval> merge = new ArrayList<>();

       for(Interval current: intervals) {
           if(merge.isEmpty() || merge.get(merge.size()-1).end < current.start) {
               merge.add(current);
           } else {
               merge.get(merge.size()-1).end = Math.max(current.end, merge.get(merge.size()-1).end);
           }
       }

       return merge;
   }

    private MergeOverlappingIntervals() {
    }

}