https://school.programmers.co.kr/learn/courses/30/lessons/72411

import java.util.*;

class Solution {
    private Map<String, Integer> map;
    private boolean[] visited;
    private int max;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int num : course) {
            map = new HashMap<>();
            max = 2;

            for (int i = 0 ; i < orders.length ; i++) {
                char[] arr = orders[i].toCharArray();
                Arrays.sort(arr);

                orders[i] = String.valueOf(arr);

                visited = new boolean[orders[i].length()];

                if (orders[i].length() >= num) {
                    dfs(orders[i], num, 0, "");
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(entry.getValue(), max);
            }

            map.entrySet().stream()
                    .filter(m -> m.getValue() >= max)
                    .forEach(m -> answer.add(m.getKey()));
        }

        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }

    private void dfs(String order, int num, int depth, String menu) {
        if (depth == num) {
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        }

        for (int i = 0 ; i < order.length() ; i++) {
            dfs(order.substring(i + 1), num, depth + 1, menu + order.charAt(i));
        }
    }
}