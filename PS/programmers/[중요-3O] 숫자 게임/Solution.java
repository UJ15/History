https://school.programmers.co.kr/learn/courses/30/lessons/12987

import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int[] A, int[] B) {
        visited = new boolean[B.length];
        int answer = 0;
        Arrays.sort(B);

        for (int num : A) {
            if (isWin(num, B)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isWin(int num, int[] B) {
        int start = 0;
        int end = B.length - 1;
        int mid = B.length / 2 - 1;

        while (start < end) {
            if (B[mid] > num) {
                end = mid - 1;
                mid = (end + start) / 2;
            } else if (B[mid] < num) {
                start = mid + 1;
                mid = (end + start) / 2;
            } else {
                break;
            }
        }

        for (int i = mid ; i < B.length ; i++) {
            if (B[i] > num && !visited[i]){
                visited[i] = true;
                return true;
            }
        }

        return false;
    }
}