https://school.programmers.co.kr/learn/courses/30/lessons/131127#

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int windowSize = 10;
        int answer = 0;
        int[] possibleWant = new int[number.length];


        for (int i = 0 ; i < windowSize ; i++) {
            for (int j = 0 ; j < want.length ; j++) {
                if (discount[i].equals(want[j])) {
                    possibleWant[j]++;
                }
            }
        }

        if (isPossible(possibleWant, number)) {
            answer++;
        }

        for (int i = 1 ; i + windowSize <= discount.length ; i++) {
            String pre = discount[i - 1];
            String now = discount[i + windowSize - 1];

            for (int j = 0 ; j < want.length ; j++) {
                if (now.equals(want[j])) {
                    possibleWant[j]++;
                }
                if (pre.equals(want[j])) {
                    possibleWant[j]--;
                }
            }

            if (isPossible(possibleWant, number)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPossible(int[] possibleWant, int[] number) {
        for (int i = 0 ; i < number.length ; i++) {
            if (possibleWant[i] != number[i]) {
                return false;
            }
        }

        return true;
    }
}