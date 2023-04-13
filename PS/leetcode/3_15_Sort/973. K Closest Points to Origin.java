class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coor> q = new PriorityQueue<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double distance =  Math.sqrt(Math.abs(x * x) + Math.abs(y * y));

            q.offer(new Coor(x, y, distance));
        }

        int[][] result = new int[k][2];

        for (int i = 0 ; i < k ; i++) {
            Coor point = q.poll();

            result[i][0] = point.x;
            result[i][1] = point.y;
        }

        return result;
    }
}

class Coor implements Comparable<Coor> {
    int x;
    int y;
    double distance;

    public Coor(int x, int y, double distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;;
    }

    @Override
    public int compareTo(Coor o) {
        return this.distance >= o.distance ? 1 : -1;
    }
}