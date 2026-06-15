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

        for(Interval i : intervals) {
            startTime.add(i.start);
            endTime.add(i.end);
        }

        Collections.sort(startTime);
        Collections.sort(endTime);

        int  i =0,j=0,count=0,max=0;
        while(i<startTime.size() && j<endTime.size()) {
            if(startTime.get(i) < endTime.get(j)) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            max = Math.max(count,max);
        }

        return max;

    }
}
