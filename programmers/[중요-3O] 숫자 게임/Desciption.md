## 핵심

B가 A를 이기는 경우만 생각해면 됐다.

너무 어렵게 접근한게 미스

SimpleCode
```java
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length - 1;
        
        for (int i = len, j = len ; i >= 0 ; i--) {
            if (A[i] < B[j]) {
                answer++;
                j--;
            }
        }
        
        return answer;
    }
}
```

## 내가 쓴 풀이

우선 해당 숫자보단 크고 가진 숫자중엔 가장 작은 수로 이기는게 핵심이라고 생각했다.

정렬 후 이분 탐색으로 가장 가까운 인덱스를 찾은다음 해당 인덱스부터 끝까지 탐색했다.

그중 이기는 숫자가 있으면 answer + 1을 했다.