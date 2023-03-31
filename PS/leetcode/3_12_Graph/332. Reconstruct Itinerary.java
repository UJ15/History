import java.util.*;

class Solution {
    private Map<String, PriorityQueue<String>> map;
    private List<String> answer;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        answer = new ArrayList<>();
        createMap(tickets);

        dfs("JFK");
        return answer;
    }

    private void dfs(String from) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(map.get(from).poll());
        }

        answer.add(0, from);
    }

    private void createMap(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue<>());
                map.get(ticket.get(0)).offer(ticket.get(1));
            } else {
                map.get(ticket.get(0)).offer(ticket.get(1));
            }
        }
    }
}