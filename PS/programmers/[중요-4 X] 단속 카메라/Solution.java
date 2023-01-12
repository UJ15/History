https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.*;

class Solution {
    List<Integer> camera;
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        int answer = 0;
        camera = new ArrayList<>();

        for (int[] route : routes) {
            if (isNotCrack(route)) {
                answer++;
                camera.add(route[1]);
            }
        }

        return answer;
    }

    private boolean isNotCrack(int[] route) {

        for (int num : camera) {
            if (num >= route[0] && num <= route[1]) {
                return false;
            }
        }

        return true;
    }
}