## 풀이
- Deque를 활용해 원형큐처럼 사용했다.
- 양수, 음수를 보고 덱내에 원소들 위치를 재위치 시키는 코드
```java
        while (deque.size() > 1) {
            int[] cur = deque.pollFirst();
            result = result + cur[0] + " ";

            if (cur[1] > 0) {
                for (int i = 0 ; i < cur[1] - 1 ; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0 ; i > cur[1] ; i--) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
```