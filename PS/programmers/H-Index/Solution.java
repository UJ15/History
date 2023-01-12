https://school.programmers.co.kr/learn/courses/30/lessons/42747

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] temp = new Integer[citations.length];

        for (int i = 0 ; i < temp.length ; i++){
            temp[i] = citations[i];
        }

        Arrays.sort(temp, Collections.reverseOrder());

        for (int i = 0 ; i < temp.length ; i++){
            if (temp[i] <= i + 1){
                return i;
            }
        }
        return temp.length;
    }
}