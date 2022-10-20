https://school.programmers.co.kr/learn/courses/30/lessons/12949

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0 ; i < answer.length ; i++) {
            for (int j = 0 ; j < answer[0].length ; j++) {
                answer[i][j] = multiplication(arr1, arr2, i, j);
            }
        }

        return answer;
    }

    private int multiplication(int[][] arr1, int[][] arr2, int i, int j) {
        int result = 0;

        for (int x = 0 ; x < arr1[0].length ; x++) {
            result += arr1[i][x] * arr2[x][j];
        }

        return result;
    }
}