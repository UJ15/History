https://www.acmicpc.net/problem/1915

## 풀이
- 가장 큰 정사각형 4095 문제와 동일
- (n + 1) * (m + 1) 너비의 DP배열을 선언하고 정사각형이 성럽하는 구간의 오른쪽 하단에 변을 기록하는 방식이다.

```java
//좌측 대각선 상단이 1이라면 dp배열의 상단, 좌측, 죄대각 값의 최소값 + 1을 기록해준다.
for (int i = 1 ; i <= n ; i++) {
        for (int j = 1 ; j <= m ; j++) {
          if (board[i - 1][j - 1] == 1) {
            int min = Math.min(Math.min(map[i - 1][j],map[i][j - 1]), map[i - 1][j - 1]);
            map[i][j] = min + 1;

            max = Math.max(max, map[i][j]);
          }
        }
      }
```