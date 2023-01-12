https://school.programmers.co.kr/learn/courses/30/lessons/77885

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0 ; i < numbers.length ; i++) {
            answer[i] = getNext(numbers[i]);
        }

        return answer;
    }

    private long getNext(long number) {
        if (number % 2 == 0) {
            return number + 1;
        }
        int flag = 0;
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            long mod = number % 2;
            if (mod == 0 && flag == 0) {
                sb.deleteCharAt(0);
                sb.insert(0, "10");
                flag = 1;
            } else {
                sb.insert(0, mod);
            }
            number /= 2;
        }

        if (flag == 0) {
            sb.deleteCharAt(0);
            sb.insert(0, "10");
        }

        return Long.parseLong(sb.toString(), 2);
    }
}