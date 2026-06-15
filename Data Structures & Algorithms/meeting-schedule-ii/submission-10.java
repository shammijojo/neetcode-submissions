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

        for(Interval interval : intervals) {
            startTime.add(interval.start);
            endTime.add(interval.end);
        }

        Collections.sort(startTime);
        Collections.sort(endTime);

        int startIndex = 0;
        int endIndex = 0;
        int meetingRooms = 0;
        int max = 0;

        while(startIndex < intervals.size()) {
            if(startTime.get(startIndex) < endTime.get(endIndex)) {
                startIndex++;
                meetingRooms++;
            } else {
                endIndex++;
                meetingRooms--;
            }
            max = Math.max(max,meetingRooms);
        }

        return max;
    }
}
