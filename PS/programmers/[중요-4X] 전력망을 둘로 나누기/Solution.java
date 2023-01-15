import java.util.*;

class Solution {

    static ArrayList<Integer> list[];

    public int solution(int n, int[][] wires) {
        int answer = 100;

        list = new ArrayList[n+1];

        for(int i = 1;i <= n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < wires.length ; i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }

        for(int i = 0 ; i<wires.length ; i++){
            int n1 = bfs(wires[i][0],wires[i][1],n);
            int n2 = bfs(wires[i][1],wires[i][0],n);

            answer = Math.min(answer,Math.abs(n1-n2));
        }

        return answer;
    }

    public static int bfs(int v1, int v2, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n+1];

        int count = 0;
        q.add(v1);
        visited[v1] = true;

        while(!q.isEmpty()){

            int cur = q.poll();
            count++;

            for(int next:list[cur]){
                if(!visited[next] && next!=v2){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return count;
    }
}
