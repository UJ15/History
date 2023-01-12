https://school.programmers.co.kr/learn/courses/30/lessons/12953

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1 ; i < arr.length ; i++) {
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }

        return answer;
    }
    //유클리드 호제법으로 최대공약수를 구한 후 두 수 의 곱을 최대공약수로 나눔
    private int gcd(int num1,int num2) {
        if (num2 == 0) {
            return num1;
        }

        return gcd(num2, num1 % num2);
    }
}