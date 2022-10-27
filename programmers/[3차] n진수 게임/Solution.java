https://school.programmers.co.kr/learn/courses/30/lessons/17687

import java.util.*;

class Solution {

    private int count;
    private int number;
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        count = 1;
        number = 0;

        while (answer.length() < t) {
            String convertedNumber = convert(n);
            answer += getAnswer(convertedNumber, m, p);
        }

        return answer.substring(0, t);
    }

    private String getAnswer(String convertedNumber, int m, int p) {
        String answer = "";

        for (int i = 0 ; i < convertedNumber.length() ; i++) {
            int seq = count % m == 0 ? m : count % m;
            if (seq == p) {
                answer += convertedNumber.charAt(i);
            }
            count++;
        }

        return answer;
    }

    private String convert(int n) {
        StringBuilder sb = new StringBuilder();

        if (number == 0) {
            number++;
            return "0";
        }

        int temp = number;

        while (temp > 0) {
            int mod = temp % n;
            String cn = mod > 9 ? ((char) (mod + 55)) + "" : mod + "";
            sb.insert(0, cn);
            temp /= n;
        }

        number++;

        return sb.toString();
    }
}