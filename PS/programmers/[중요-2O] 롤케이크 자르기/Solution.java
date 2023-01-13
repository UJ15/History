https://school.programmers.co.kr/learn/courses/30/lessons/132265

import java.util.*;

class Solution {
    Map<Integer, Integer> map;
    List<Integer> list;

    public int solution(int[] topping) {
        list = new ArrayList<>();
        map = new HashMap<>();
        int answer = 0;
        int my = 0;
        int kind = createMap(topping);

        for (int top : topping) {
            if (!list.contains(top)) {
                my++;
                list.add(top);
            }

            map.put(top, map.get(top) - 1);

            if (map.get(top) <= 0) {
                kind--;
            }

            if (my == kind) {
                answer++;
            }
        }

        return answer;
    }

    private int createMap(int[] topping) {
        for (int top : topping) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }

        return map.size();
    }
}