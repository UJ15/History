## 핵심
- 플로이드 와샬 완전탐색 문제
- 플로이드 와샬 알고리즘만 알면 쉽게 풀 수 있다.
- 모든 정점간 최단거리를 구한 후 모든 정점간 합승 후 집으로 간 거리를 더해서 최소값을 반환해주면 정답.

### 플로이드 와샬 알고리즘
```java
    public void createFloyd(int n, int[][] fares) {
        //초기화
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (i == j) {
                    floyd[i][j] = 0;
                } else {
                    floyd[i][j] = MAX_FARE;
                }

            }
        }
        
        //간선 추가
        for (int[] fare : fares) {
            floyd[fare[0]][fare[1]] = fare[2];
            floyd[fare[1]][fare[0]] = fare[2];
        }
        
        //각 정점을 지나갈경우 비용 계산
        //i = 지나갈 정점, j = 출발 정점, k = 도착 정점
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                for (int k = 1 ; k <= n ; k++) {
                    floyd[j][k] = Math.min(floyd[j][k], floyd[j][i] + floyd[i][k]);
                }
            }
        }
    }
```