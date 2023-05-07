## 풀이

- 분기문으로 단순 구현했다. 핵심은 무승부 처리와 한 팀이 이겼을때 처리, 이 부분을 조금 고민했다.
```java
if (team1 > team2) {
                winner = 1;
            } else if (team1 < team2) {
                winner = 2;
            } else {
                winner = 0;
            }

            //무승부시 그동안 이겨왔던 팀 데이터 처리
            if (winner == 0) {
                if (lastTime[0] == 1) {
                    result1 += time - lastTime[1];
                } else if (lastTime[0] == 2) {
                    result2 += time - lastTime[1];
                }
            }

            //기존 승자가 바뀌었을 경우 데이터 변경
            if (lastTime[0] != winner) {
                lastTime[0] = winner;
                lastTime[1] = time;
            }
```