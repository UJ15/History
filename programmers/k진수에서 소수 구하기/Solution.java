https://school.programmers.co.kr/learn/courses/30/lessons/92335

import java.util.*;

class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        String convertedNum = convert(n, k);
        String[] candidate = convertedNum.split("0");

        for (String number : candidate) {

            if (number.equals("") || number.equals("1")) {
                continue;
            }

            if (isPrime(Long.parseLong(number))) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long number) {
        for (long i = 2 ; i * i <= number ; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }

        return sb.toString();
    }
}