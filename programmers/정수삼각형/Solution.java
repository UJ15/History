https://school.programmers.co.kr/learn/courses/30/lessons/43105

class Solution {

    private int answer = 0;
    public int solution(int[][] triangle) {
        int[][] visited = new int[triangle.length][triangle.length];
        visited[0][0] = triangle[0][0];

        for (int i = 1 ; i < triangle.length ; i++) {
            for (int j = triangle[i].length - 1 ; j >= 0 ; j--) {
                int current = triangle[i][j];

                if (j == triangle[i].length - 1) {
                    visited[i][j] = current + visited[i-1][j-1];
                } else if (j == 0) {
                    visited[i][j] = current + visited[i-1][j];
                } else {
                    visited[i][j] = current + Math.max(visited[i-1][j-1], visited[i-1][j]);
                }
            }
        }

        for (int i = 0 ; i < triangle.length ; i++) {
            answer = Math.max(answer, visited[triangle.length - 1][i]);
        }

        return answer;
    }
}