https://school.programmers.co.kr/learn/courses/30/lessons/87694

import java.util.*;

//사각형의 테두리를 그리는게 좀 헷갈린다.
//전체 사각형을 그리고 내부를 지우는 방식으로 했었는데 틀렸었다. x축 y축이 헷갈린거 같음
class Solution {

    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, -1, 0, 1};
    private final int[][] map = new int[102][102];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        for (int[] rec : rectangle) {
            markRectangle(rec);
        }

        int distance = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return distance / 2;
    }


    private void markRectangle(int[] rectangle) {

        for (int i = rectangle[1] * 2 ; i <= rectangle[3] * 2 ; i++) {
            for (int j = rectangle[0] * 2 ; j <= rectangle[2] * 2 ; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                map[i][j] = -1;
                if (i == rectangle[1] * 2 ||
                        j == rectangle[0] * 2 ||
                        i == rectangle[3] * 2 ||
                        j == rectangle[2] * 2) {
                    map[i][j] = 1;
                }
            }
        }
    }

    private int bfs(int cX, int cY, int iX, int iY) {

        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[102][102];
        q.offer(new int[] {cY, cX});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cy = current[0];
            int cx = current[1];

            for (int i = 0 ; i < 4 ; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0) {
                    continue;
                }

                if (map[ny][nx] == 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[cy][cx] + 1;
                    q.offer(new int[] {ny, nx});
                }
            }
        }

        return visited[iY][iX];
    }
}