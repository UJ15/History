## 풀이
https://www.acmicpc.net/problem/1966

- 덱과 우선순위 큐를 이용해서 풀었다.
- 처음엔 좀 복잡하게 생각해서 덱을 쓰기로 했는데 사실 큐를 써도 되고 리스트를 써도 된다.
- 우선순위큐는 내림차순으로 정렬을 해줘서 항상 큐에 남아있는 최대값을 표시해준다.
- 큐의 맨 앞이 우선순위큐의 맨 앞보다 작을경우 맨뒤로 넘겨주며 큐의 값들을 지워나간다.
- 타겟이 프린트될 경우 해당 순서를 반환한다.