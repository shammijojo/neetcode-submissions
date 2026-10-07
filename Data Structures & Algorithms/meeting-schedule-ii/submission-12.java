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
        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();

        for(Interval x : intervals) {
            startTime.add(x.start);
            endTime.add(x.end);
        }

        Collections.sort(startTime);
        Collections.sort(endTime);

        int i = 0;
        int j = 0;
        int meetingRooms = 0;
        int max = 0;

        while(i < intervals.size()) {
            if(startTime.get(i) < endTime.get(j)) {
                i++;
                meetingRooms++;
            } else {
                j++;
                meetingRooms--;
            }
            max = Math.max(max,meetingRooms);
        }

        return max;
    }
}
