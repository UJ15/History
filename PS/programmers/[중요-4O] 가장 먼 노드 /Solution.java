https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

class Solution {

    class Node {
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }

    private int max;
    private int count;
    private List<List<Integer>> list;

    public int solution(int n, int[][] edge) {
        max = 0;
        count = 0;
        list = new ArrayList<>();

        for (int i = 0; i <= n ; i++) {
            list.add(new ArrayList());
        }

        for (int i = 0 ; i < edge.length ; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }

        bfs(n);

        return count;
    }

    public void bfs(int n) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(new Node(1, 0));
        visited[1] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();
            List<Integer> cur = list.get(current.num);
            if (current.dis > max) {
                count = 0;
                max = current.dis;
            }
            count++;

            for (int i = 0 ; i < cur.size() ; i++) {
                if (!visited[cur.get(i)]) {
                    visited[cur.get(i)] = true;
                    q.offer(new Node(cur.get(i), current.dis + 1));

                }
            }
        }
    }
}