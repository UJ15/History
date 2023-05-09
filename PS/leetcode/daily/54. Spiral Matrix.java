/***
 * Queue를 이용해서 BFS처럼 풀었다.
 * 방향전환을 반복하면서 불가능한 인덱스일경우 리턴턴
 * 굳이 Queue안쓰고 무한루프 돌면서 다음인덱스 보고 처리해도 될듯?
 *
 * */


class Solution {
    List<Integer> result;
    int direction;
    boolean[][] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        direction = 0;
        int length = matrix.length;
        int height = matrix[0].length;

        visited = new boolean[length][height];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            result.add(matrix[cur[0]][cur[1]]);

            int nextX = cur[0] + dx[direction];
            int nextY = cur[1] + dy[direction];

            if (nextX < 0 || nextY < 0 || nextX == length || nextY == height || visited[nextX][nextY]) {
                direction = (direction + 1) % 4;
                nextX = cur[0] + dx[direction];
                nextY = cur[1] + dy[direction];
            }

            if (nextX < 0 || nextY < 0 || nextX == length || nextY == height || visited[nextX][nextY]) {
                break;
            }

            q.offer(new int[] {nextX, nextY});
        }

        return result;
    }
}