/***
 * 같은 숫자는 싫어
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java
 */

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;

        for (int i = 0 ; i < arr.length ; i++) {
            if (prev != arr[i]) {
                list.add(arr[i]);
            }

            prev = arr[i];
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}