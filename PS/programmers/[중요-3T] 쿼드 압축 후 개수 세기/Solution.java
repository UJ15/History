https://school.programmers.co.kr/learn/courses/30/lessons/68936

import java.util.*;

class Solution {
    private int zeroCount = 0;
    private int oneCount = 0;

    public int[] solution(int[][] arr) {
        int length = arr.length;

        if (isNotCompress(0, 0, length, arr)) {
            splitQuad(0, 0, length, arr);
        }

        return new int[] {zeroCount, oneCount};
    }

    private void splitQuad(int startI, int startJ, int n, int[][] arr) {

        for (int i = startI ; i <= startI + n / 2 ; i += n / 2) {
            for (int j = startJ ; j <= startJ + n / 2 ; j += n / 2) {
                if (isNotCompress(i, j, n / 2, arr)) {
                    splitQuad(i, j, n / 2, arr);
                }
            }
        }
    }

    private boolean isNotCompress(int i, int j, int increase, int[][] arr) {
        int num = arr[i][j];

        for (int x = 0 ; x < increase ; x++) {
            for (int y = 0 ; y < increase ; y++) {
                if (num != arr[i + x][j + y]) {
                    return true;
                }
            }
        }

        if (num == 1) {
            oneCount++;
        } else {
            zeroCount++;
        }

        return false;
    }
}