https://school.programmers.co.kr/learn/courses/30/lessons/64062

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = 200_000_000;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isAcrossRiver(mid, stones, k)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private boolean isAcrossRiver(int limit, int[] stones, int k) {
        int skip = 0;

        for (int stone : stones) {
            if (stone < limit) {
                skip++;
            } else {
                skip = 0;
            }

            if (skip == k) {
                return false;
            }
        }

        return true;
    }
}