/*기존에는 정렬 후 Map의 Value를 List로 정하고 목적지를 넣어서 DFS를 돌렸는데 실패했다.
마지막 목적지 처리가 까다로웠다.
아래처럼 마지막 목적지 까지 재귀호출한 후 역순으로 List에 넣으면 성공한다. 아마 정순으로 넣는 방법은 다른 로직이 필요할 것 같다.
그 방법은 아직 못찾았다.
 */

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