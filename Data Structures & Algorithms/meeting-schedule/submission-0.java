/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Comparator comparator = new Comparator<Interval>() {
            public int compare(Interval a,Interval b) {
                return Integer.compare(a.start,b.start);
            }
        };
        Collections.sort(intervals,comparator);

        for(int i = 1; i < intervals.size();i++) {
            if(intervals.get(i).start<intervals.get(i-1).end) {
                return false;
            }
        }

        return true;

    }
}
