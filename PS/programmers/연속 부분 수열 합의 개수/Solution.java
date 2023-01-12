https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();

    public int solution(int[] elements) {

        for (int i = 1 ; i <= elements.length ; i++) {
            for (int j = 0 ; j < elements.length ; j++) {
                int sum = 0;
                for (int k = 0 ; k < i ; k++) {
                    int index = (j + k) % elements.length;
                    sum += elements[index];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}