https://school.programmers.co.kr/learn/courses/30/lessons/12980

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 1;

        while (n != 1) {
            if (n % 2 == 1) {
                n -= 1;
                answer++;
            }

            n /= 2;
        }

        return answer;
    }
}