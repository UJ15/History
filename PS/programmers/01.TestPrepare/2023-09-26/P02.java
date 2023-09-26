/***
 * 최소직사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */

class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;

        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                wMax = Math.max(size[1], wMax);
                hMax = Math.max(size[0], hMax);
            }
            else {
                wMax = Math.max(size[0], wMax);
                hMax = Math.max(size[1], hMax);
            }
        }

        return wMax * hMax;
    }
}