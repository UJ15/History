https://school.programmers.co.kr/learn/courses/30/lessons/12979

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;

        for (int num : stations) {
            if (start < num - w) {
                int end = num - w;
                int length = end - start;
                int count = length / (2 * w + 1);

                if (length % (2 * w + 1) != 0) {
                    count++;
                }

                answer += count;
            }

            start = num + w + 1;
        }

        if (stations[stations.length - 1] + w < n) {
            start = stations[stations.length - 1] + w + 1;
            int end = n;
            int length = end - start + 1;
            int count = length / (2 * w + 1);

            if (length % (2 * w + 1) != 0) {
                count++;
            }

            answer += count;
        }

        return answer;
    }
}