https://school.programmers.co.kr/learn/courses/30/lessons/43164

import java.util.*;

class Solution {
    List<String> routes = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, visited, 0);

        Collections.sort(routes);
        return routes.get(0).split(" ");
    }

    private void dfs(String start, String route, String[][] tickets, boolean[] visited, int depth) {
        if (depth == tickets.length) {
            routes.add(route);
            return;
        }

        for (int i = 0 ; i < tickets.length ; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}