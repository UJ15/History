https://school.programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;

class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private Queue<String> q = new LinkedList<>();
    private Set<String> set = new HashSet<>();

    public int[] solution(String[] gems) {
        set.addAll(Arrays.asList(gems));
        int[] answer = new int[2];
        int start = 0;
        int idx = 0;
        int len = Integer.MAX_VALUE;

        for (int i = 0 ; i < gems.length ; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            q.offer(gems[i]);

            while (map.get(q.peek()) > 1) {
                map.put(q.peek(), map.get(q.poll()) - 1);
                idx++;
            }

            if (set.size() == map.size() && len > (i - idx)) {
                len = i - idx;
                start = idx + 1;
            }
        }

        return new int[] {start, start + len};
    }
}