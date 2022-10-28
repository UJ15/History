## 핵심

- 종료지점 순으로 정렬 `route[1] 종료지점 순 정렬`
- `Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));`
- Comparator 사용법을 익히자
- 람다 말고 오버라이딩 
```java
Arrays.sort(routes, new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    });
```
- 범위내에 카메라가 없다면 종료지점에 설치

## 내 접근
- 접근 실패
- 풀이 생각이 나지 않음

## 탐욕법(Greedy)에 대해
- 