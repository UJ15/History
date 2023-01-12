https://school.programmers.co.kr/learn/courses/30/lessons/68645

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        List<Integer> list = new ArrayList<>();

        fillTriangle(0, 0, map, n, 1);

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (map[i][j] > 0) {
                    list.add(map[i][j]);
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private void fillTriangle(int sc, int sr, int[][] map, int n, int count) {
        int tempCol = sc - 1;
        int tempRow = sr;

        for (int i = 0 ; i < n ; i++) {
            map[i + sc][sr] = count++;
            tempCol++;
        }

        for (int i = 1 ; i < n ; i++) {
            map[tempCol][sr + i] = count++;
            tempRow++;
        }

        for (int i = 1 ; i < n - 1 ; i++) {
            map[--tempCol][--tempRow] = count++;
        }

        if (n > 3) {
            fillTriangle(sc + 2, sr + 1, map, n - 3, count);
        }
    }
}

