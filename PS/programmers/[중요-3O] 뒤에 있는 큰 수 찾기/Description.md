## 풀이

- 스택을 활용하는 문제
- 스택에 index와 값을 넣어두고 해당 값보다 큰값이 왔을때 기록해준다. 마지막에 스택에 남아있는 수들은 뒷큰수가 없는 값들이다.

핵심 코드
```java
for (int i = 0 ; i < numbers.length ; i++) {
    while (!stack.isEmpty()) {
        int[] cur = stack.peek();
        if (cur[1] < numbers[i]) {
            answer[cur[0]] = numbers[i];
            stack.pop();
        } else {
            break;
        }
    }
    
    stack.push(new int[] {i, numbers[i]});
}
```