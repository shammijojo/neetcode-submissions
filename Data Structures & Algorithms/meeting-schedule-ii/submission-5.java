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
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for(Interval interval : intervals) {
            start.add(interval.start);
            end.add(interval.end);
        }
        Collections.sort(start);
        Collections.sort(end);

        int max = 0, concurrentMeetings = 0;
        int i = 0, j = 0;

        while(i < start.size()) {
            if(start.get(i) < end.get(j)) {
                concurrentMeetings++;
                i++;
            } else {
                concurrentMeetings--;
                j++;
            } 
            max = Math.max(max,concurrentMeetings);
        }

        return max;
    }
}
