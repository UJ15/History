https://school.programmers.co.kr/learn/courses/30/lessons/87390#qna

import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();

        //여기 n을 long으로 형변환하는게 포인트다 자료형 계산할때 생각해보자
        int row = (int) (left / (long) n) + 1;
        int start = (int) (left % (long) n);
        int count = (int) (right - left + 1);

        for (int i = 0 ; i < count ; i++) {
            if (start == n) {
                start = 0;
                row++;
            }
            if (start < row) {
                answer.add(row);
            } else {
                answer.add(start + 1);
            }
            start++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}