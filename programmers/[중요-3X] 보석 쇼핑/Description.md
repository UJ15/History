## 핵심
- 맵과 큐를 사용하는 것까지는 알았다.
- set과 length를 활용해서 end를 구하는게 포인트다.

```java

for (int i = 0 ; i < gems.length ; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            q.offer(gems[i]);

            while (map.get(q.peek()) > 1) {
                map.put(q.peek(), map.get(q.poll()) - 1);
                idx++;
            }
            //이부분이 핵심 len을 갱신하면서 start를 고정하는게 핵심
            if (set.size() == map.size() && len > (i - idx)) {
                len = i - idx;
                start = idx + 1;
            }
        }
```