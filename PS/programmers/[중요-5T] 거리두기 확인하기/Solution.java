import java.util.*;

class Solution {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private String[] map;

    public int[] solution(String[][] places) {
        List<Integer> list = new ArrayList<>();

        for (String[] place : places) {
            int result = getResult(place);

            list.add(result);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private int getResult(String[] place) {
        map = place;

        for (int i = 0 ; i < map.length ; i++) {
            for (int j = 0 ; j < map.length ; j++) {
                char c = map[i].charAt(j);
                if (c == 'P' && bfs(i, j)) {
                    return 0;
                }
            }
        }

        return 1;
    }

    private boolean bfs(int i, int j) {
        Queue<Coor> q = new LinkedList<>();
        q.offer(new Coor(i, j, 0));

        while (!q.isEmpty()) {
            Coor current = q.poll();
            int ci = current.i;
            int cj = current.j;
            int cLevel = current.level;

            if (cLevel == 2) {
                break;
            }

            for (int k = 0 ; k < 4 ; k++) {
                int ni = ci + dx[k];
                int nj = cj + dy[k];
                int nLevel = cLevel + 1;

                if (ni < 0 || ni >= map.length || nj < 0 || nj >= map.length) {
                    continue;
                }

                if (ni == i && nj == j) {
                    continue;
                }

                if (map[ni].charAt(nj) == 'O') {
                    q.offer(new Coor(ni, nj, nLevel));
                } else if (map[ni].charAt(nj) == 'P') {
                    return true;
                }
            }
        }

        return false;
    }
}

class Coor {
    int i;
    int j;
    int level;

    public Coor(int i, int j, int level) {
        this.i = i;
        this.j = j;
        this.level = level;
    }
}