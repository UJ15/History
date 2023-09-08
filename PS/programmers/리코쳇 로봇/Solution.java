import java.util.*;

class Solution {
    private int[] robotCoordinate;
    private int[] goalsCoordinate;
    private boolean[][] visited;
    private int[] dx = new int[] {0, 0, -1, 1};
    private int[] dy = new int[] {1, -1, 0, 0};

    public int solution(String[] board) {
        initCoordinate(board);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {robotCoordinate[0], robotCoordinate[1], 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int level = current[2];

            for (int i = 0 ; i < 4 ; i++) {
                int nextX = x;
                int nextY = y;

                while (!isStop(nextX, nextY, board)) {
                    nextX += dx[i];
                    nextY += dy[i];
                }

                nextX -= dx[i];
                nextY -= dy[i];

                if (nextX == goalsCoordinate[0] && nextY == goalsCoordinate[1]) {
                    return level + 1;
                }

                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;

                    q.offer(new int[] {nextX, nextY, level + 1});
                }
            }
        }
        return -1;
    }

    private boolean isStop(int x, int y, String[] board) {
        return x < 0 || y < 0 || x >= board.length || y >= board[0].length() || board[x].charAt(y) == 'D';
    }

    private void initCoordinate(String[] board) {
        visited = new boolean[board.length][board[0].length()];

        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length() ; j++) {
                if (board[i].charAt(j) == 'R') {
                    robotCoordinate = new int[] {i, j};
                }

                if (board[i].charAt(j) == 'G') {
                    goalsCoordinate = new int[] {i, j};
                }
            }
        }
    }
}