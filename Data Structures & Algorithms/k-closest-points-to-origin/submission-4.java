class Solution {
    private class Coordinates {
        int x;
        int y;
        double distance;

        Coordinates(int x,int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinates> pq = new PriorityQueue<>((a,b) -> Double.compare(b.distance,a.distance));
        for(int i = 0; i < points.length; i++) {
            double distance = getDistance(points[i][0],points[i][1],0,0);
            pq.add(new Coordinates(points[i][0],points[i][1],distance));
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[pq.size()][2];
        int index = 0;
        while(!pq.isEmpty()) {
            result[index][0] = pq.peek().x;
            result[index][1] = pq.peek().y;
            pq.poll();
            index++;
        }

        return result;



    }

    private double getDistance(int x1,int y1, int x2,int y2) {
        double xSquare = Math.pow(x1-x2,2);
        double ySquare = Math.pow(y1-y2,2);

        return Math.sqrt(xSquare+ySquare);
    }
}
