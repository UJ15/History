## 핵심

---
- **두 번 틀린문제**
- 짝수일 경우 +  1;
- 홀수일경우 0의 유무에 따라 다름
  - 0이 존재할 경우 = 맨 뒤의 0과 그 뒤의 1의 위치를 바꿔준다.
  - 0이 존재하지 않을 경우 = 맨 앞에 1을 추가해주고 그 뒷자리를 0으로 바꿔준다.

씸플 코드
```java
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            
            answer[i] += (answer[i]^numbers[i])>>>2; //비트연산
        }
        return answer;
    }
}
```

## 자바 비트 연산에대해

- `>>>` : 오른쪽으로 비트를 이동하며 빈공간을 0으로 채움
- `^` : XOR 연산

```java
        int target = 11;
        int targetPlusOne = 12;

        System.out.println("target  =  " + Integer.toBinaryString(target));
        System.out.println("target++ = " + Integer.toBinaryString(targetPlusOne));
        //XOR 연산 후
        System.out.println("target^target++ = " + Integer.toBinaryString(target^targetPlusOne));
        //시프트 연산 후
        System.out.println("XOR>>>2 = " + Integer.toBinaryString((target^targetPlusOne)>>>2));
        System.out.println("result = " + (targetPlusOne +  ((target^targetPlusOne)>>>2)));
```

결과
```java
      target  =  1011
      target++ = 1100
      target^target++ = 111
      XOR>>>2 = 1
      result = 13
```

