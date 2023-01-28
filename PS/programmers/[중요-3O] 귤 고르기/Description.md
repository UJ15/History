c## 핵심

- HashMap을 이용해 귤의 종류별로 각각의 개수를 저장해둔다.
- 내림차순으로 정렬한다.
- Map을 순회하며 k가 0혹은 음수가 되는 구간에서 카운팅한 종류를 반환한다.
---
## 맵 정렬 
- Value를 기준으로 정렬했다.
- 각 Entry를 리스트로 정렬

```java
List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toList());
```