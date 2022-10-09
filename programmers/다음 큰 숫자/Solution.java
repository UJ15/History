https://school.programmers.co.kr/learn/courses/30/lessons/12911

class Solution {
    public int solution(int n) {
        final int ones = countOne(n);
        int answer = n + 1;

        while (true) {
            if (ones == countOne(answer)) {
                break;
            }
            answer++;
        }

        return answer;
    }

    private int countOne(int n) {
        int count = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }

        return count;
    }
}