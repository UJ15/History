class Solution {
    private int max;
    private int count;
    private Set<String> visited;

    public int maximumDetonation(int[][] bombs) {
        max = 0;

        for (int i = 0 ; i < bombs.length ; i++) {
            int[] bomb = bombs[i];
            visited = new HashSet<>();
            visited.add(bomb[0] + "-" + bomb[1] + "-" + i);
            count = 0;
            dfs(bomb[0], bomb[1], bomb[2], bombs);
            max = Math.max(count, max);
        }

        return max;
    }

    private void dfs(int x, int y, int r, int[][] bombs) {
        max = Math.max(count, max);

        count++;

        for (int i = 0 ; i < bombs.length ; i++) {
            int[] bomb = bombs[i];
            if (isInOfDetonateRange(bomb[0], bomb[1], x, y, r) && !visited.contains(bomb[0] + "-" + bomb[1] + "-" + i)) {
                System.out.println();
                visited.add(bomb[0] + "-" + bomb[1] + "-" + i);
                dfs(bomb[0], bomb[1], bomb[2], bombs);
            }
        }
    }

    private boolean isInOfDetonateRange(int zx, int zy, int xx, int yy, int rr) {
        long tx = (long) zx;
        long ty = (long) zy;
        long x = (long) xx;
        long y = (long) yy;
        long r = (long) rr;
        return (tx - x) * (tx - x) + (ty - y) * (ty - y) <= r * r;
    }
}