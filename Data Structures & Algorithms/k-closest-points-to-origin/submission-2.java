class Solution {
    class Point {
        private int x;
        private int y;
        private double distance;

        Point(int x,int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        List<Point> pointsList = new ArrayList<>();
        for(int i = 0; i < points.length; i++) {
            pointsList.add(new Point(points[i][0],points[i][1],
            getDistanceFromOrigin(points[i][0],points[i][1])));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((p1,p2) -> Double.compare(p2.distance,p1.distance));
        for(Point point : pointsList) {
            pq.add(point);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            Point point = pq.poll();
            result[i++] = new int[]{point.x,point.y};
        }

        return result;

    }

    private double getDistanceFromOrigin(int x, int y) {
        double distance = 0;
        double xsquare = Math.pow(x,2);
        double ysquare = Math.pow(y,2);
        distance = Math.sqrt(xsquare+ysquare);
        return distance;
    }
}
