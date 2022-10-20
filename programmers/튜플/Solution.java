https://school.programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        String str = s.replaceAll("\\{|\\}", "");
        String[] nums = str.split(",");

        for (String num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            answer.add(Integer.parseInt(entry.getKey()));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}