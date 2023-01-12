import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

class Solution {//우선순위 큐를 value로 써서 사전식으롤 도착지를 정렬
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> result = new ArrayList<String>();
        
        for (int i = 0 ; i < tickets.size() ; i++){
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            
            if (map.containsKey(from)){
                map.get(from).offer(to);
            }
            else{
                PriorityQueue<String> heap = new PriorityQueue<String>();
                heap.offer(to);
                map.put(from, heap);
            }
        }
        
        dfs("JFK", map, result);
        return result;
    }
    
   public void dfs(String from, Map<String, PriorityQueue<String>> map, List<String> result){
       PriorityQueue<String> arrival = map.get(from);
       while(arrival != null && !arrival.isEmpty()){
           String to = arrival.poll();
           dfs(to, map, result);//큐가 빌때까지 재귀호출
       }
       result.add(0, from);//역순으로 리스트에 삽입
   }
        
}
