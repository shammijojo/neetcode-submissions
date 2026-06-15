class Solution {
    private class Pair {
        char c;
        int frequency;

        Pair(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> p2.frequency-p1.frequency);
        if(a > 0)
        pq.add(new Pair('a',a));
        if(b > 0)
        pq.add(new Pair('b',b));
        if(c > 0)
        pq.add(new Pair('c',c));

        StringBuilder result = new StringBuilder();

        while(!pq.isEmpty()) {
            Pair p1 = pq.poll();

            int size = result.length();
            if(size >= 2) {
                if(result.charAt(size-1) == result.charAt(size-2) &&
                result.charAt(size-1) == p1.c) {
                    if(pq.isEmpty()) {
                        return result.toString();
                    }
                    Pair p2 = pq.poll();
                    result.append(p2.c);
                    p2.frequency--;
                    if(p2.frequency > 0) {
                        pq.add(p2);
                    }
                }
            } else {
                result.append(p1.c);
                p1.frequency--;
                if(p1.frequency > 0) {
                    pq.add(p1);
                }
            }
        }

        return result.toString();
    }
}