## 풀이
- 기본 다익스트라 문제
- 핵심 코드
```java
    private static void dijkstra(int src) {
        //우선순위 큐
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        //출발점 삽입
        q.offer(new int[] {src, 0});
        //DP 배열에 모든 정점 가중치를 최대값으로 설정
        Arrays.fill(dist, INF);
        //출발점은 0으로 설정
        dist[src] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (visited[current[0]]) {
                continue;
            }

            visited[current[0]] = true;

            //출발점부터 현재 정점까지의 최소값과 다음 정점으로의 최소값을 갱신하는 작업
            for (int[] next : graph[current[0]]) {
                if (dist[next[0]] > dist[current[0]] + next[1]) {
                    dist[next[0]] = dist[current[0]] + next[1];

                    q.offer(new int[] {next[0], dist[next[0]]});
                }
            }
        }
        //출발지부터 모든 정점간 최소 비용이 DP 배열에 저장되었다.
    }
```