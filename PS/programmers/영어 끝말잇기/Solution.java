https://school.programmers.co.kr/learn/courses/30/lessons/12981

import java.util.*;

class Solution {
    private String last;
    private String first;

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int turn = 0;

        for (int i = 0 ; i < words.length ; i++) {

            if (i % n == 0) {
                turn++;
            }

            if (!validate(words, words[i], i)) {
                answer[0] = i % n + 1;
                answer[1] = turn;
                return answer;
            }
        }

        answer[0] = 0;
        answer[1] = 0;

        return answer;
    }

    private boolean validate(String[] words, String now, int index) {

        if (index == 0) {
            last = now.substring(now.length() - 1, now.length());
            return true;
        }

        if (!now.substring(0, 1).equals(last)) {
            return false;
        }

        for (int i = 0 ; i < index ; i++) {
            if (now.equals(words[i])) {
                System.out.println(now);
                return false;
            }
        }

        last = now.substring(now.length() - 1, now.length());
        return true;
    }
}