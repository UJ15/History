https://school.programmers.co.kr/learn/courses/30/lessons/49994

class Solution {
    private int[][] map;
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};

    public int solution(String dirs) {
        map = new int[11][11];
        boolean[][][] visited = new boolean[11][11][4];
        int answer = 0;
        int currentCol = 5;
        int currentRow = 5;

        for (int i = 0 ; i < dirs.length() ; i++) {
            int d = 0;

            switch(dirs.charAt(i)) {
                case 'U' : d = 0;
                    break;
                case 'D' : d = 1;
                    break;
                case 'L' : d = 2;
                    break;
                case 'R' : d = 3;
                    break;
            }

            int newCol = currentCol + dx[d];
            int newRow = currentRow + dy[d];

            if (newCol < 0 || newRow < 0 || newCol > 10 || newRow > 10) {
                continue;
            }

            if (!visited[newRow][newCol][d]) {
                visited[newRow][newCol][d] = true;
                int rd = (d % 2) == 0 ? 1 : -1;
                visited[currentRow][currentCol][d + rd] = true;
                answer++;
            }

            currentCol = newCol;
            currentRow = newRow;
        }

        return answer;
    }
}