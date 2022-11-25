import java.util.*;

class Solution {
    boolean[] visited;
    boolean[] can;
    List<List<Node>> list;

    public int solution(int N, int[][] road, int K) {
        visited = new boolean[N + 1];
        can = new boolean[N + 1];
        list = new ArrayList<>();
        int count = 0;

        for (int i = 0 ; i <= N  ; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] info : road) {
            list.get(info[0]).add(new Node(info[1], info[2]));
            list.get(info[1]).add(new Node(info[0], info[2]));
        }

        dfs(1, N, K, 0);

        for (int i = 1 ; i < can.length ; i++) {
            if (can[i]) {
                count++;
            }
        }

        return count;
    }

    private void dfs(int depth, int N, int K, int current) {
        if (current > K) {
            return;
        }

        can[depth] = true;

        for (Node node : list.get(depth)) {
            if (!visited[node.next] && current + node.cost <= K) {
                visited[node.next] = true;
                dfs(node.next, N, K, current + node.cost);
                visited[node.next] = false;
            }
        }
    }

    class Node {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}