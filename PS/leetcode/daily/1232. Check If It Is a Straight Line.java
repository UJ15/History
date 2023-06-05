class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        boolean flag = false;

        double m = 0.0;
        for (int i = 1 ; i < coordinates.length ; i++) {
            int[] coor = coordinates[i];

            if (coor[0] == x) {
                if (m != 0.0) {
                    return false;
                }
                flag = true;
            }

            if (flag) {
                if (x != coor[0]) {
                    return false;
                }
                continue;
            }

            double n = (double) (coor[1] - y) / (double) (coor[0] - x);

            if (i == 1) {
                m = n;
                x = coor[0];
                y = coor[1];
                continue;
            }

            if (m != n) {
                return false;
            }

            x = coor[0];
            y = coor[1];
        }

        return true;
    }
}