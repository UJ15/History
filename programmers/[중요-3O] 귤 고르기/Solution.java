//https://school.programmers.co.kr/learn/courses/30/lessons/138476

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        put(tangerine);
        answer = getKinds(k);

        return answer;
    }

    private void put(int[] tangerine) {
        for (int i = 0 ; i < tangerine.length ; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
    }

    private int getKinds(int k) {
        int kinds = 0;

        List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (Map.Entry<Integer,Integer> entry : entries) {
            k -= entry.getValue();
            kinds++;
            if (k <= 0) {
                break;
            }
        }

        return kinds;
    }
}