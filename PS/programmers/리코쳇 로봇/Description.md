## 핵심
- BFS로 위치 최단 경로를 찾는 기본 문제의 변형이다.
- 핵심은 움직일 수 없을때까지 이동하는 로직

```java
                while (!isStop(nextX, nextY, board)) {
                    nextX += dx[i];
                    nextY += dy[i];
                }

                nextX -= dx[i];
                nextY -= dy[i];
```