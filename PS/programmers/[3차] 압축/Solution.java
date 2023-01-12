https://school.programmers.co.kr/learn/courses/30/lessons/17684

import java.util.*;

class Solution {
    private Map<String, Integer> map = new HashMap<>();

    public int[] solution(String msg) {
        List<Integer> print = new ArrayList<>();

        int count = initMap();
        String buffer = "";

        for (int i = 0 ; i < msg.length() - 1 ; i++) {
            buffer += msg.charAt(i);
            char next = msg.charAt(i + 1);

            if (map.containsKey(buffer + next)) {
                continue;
            } else {
                print.add(map.get(buffer));
                map.put(buffer + next, count++);
                buffer = "";
            }
        }

        buffer += msg.charAt(msg.length() - 1);
        print.add(map.get(buffer));

        return print.stream().mapToInt(i -> i).toArray();
    }

    private int initMap() {
        int num = 1;
        for (int i = 65 ; i <= 90 ; i++) {
            map.put("" + (char) i, num++);
        }

        return num;
    }
}