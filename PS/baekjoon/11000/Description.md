## 풀이
- 우선순위 큐 두 개를 활용해서 해결하면 간단하다.
- q1은 강의가 시작하는 시간을 순서대로 최소힙
- q2는 강의가 끝나는 시간을 순서대로 최소힙
- 두 값을 비교하여 먼저 끝나는 강의가 있다면 q2에서 원소 제거 후 삽입.
- q2의 최대 크기가 필요한 강의실 크기