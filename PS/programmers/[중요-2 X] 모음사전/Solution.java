https://school.programmers.co.kr/learn/courses/30/lessons/84512

class Solution {
    private static final String AEIOU = "AEIOU";
    private static final int[] UNITS = {781, 156, 31, 6, 1};

    public int solution(String word) {
        int answer = 0;
        for (int i = 0 ; i < word.length() ; i++) {
            answer += UNITS[i] * AEIOU.indexOf(word.charAt(i)) + 1;
        }
        return answer;
    }
}