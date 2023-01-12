
https://school.programmers.co.kr/learn/courses/30/lessons/12971

class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;

        if (len == 1) {
            return sticker[0];
        }

        int[] d1 = new int[len]; //첫번째 스티커를 선택한 경우
        int[] d2 = new int[len]; //선택하지 않은 경우

        d1[0] = sticker[0]; //첫번째 스테커를 선택하면 두번째, 마지막은 사용 불가능 len - 1 이것과 두 번째 최대값도 stickeer[0]으로 초기화
        d1[1] = sticker[0];

        for (int i = 2 ; i < len - 1; i++) {
            d1[i] = Math.max(d1[i - 1], d1[i - 2] + sticker[i]);
        }

        d2[0] = 0;//선택한 경우
        d2[1] = sticker[1];

        for (int i = 2 ; i < len ; i++) {
            d2[i] = Math.max(d2[i - 1], d2[i - 2] + sticker[i]);
        }

        return Math.max(d1[len - 2], d2[len - 1]); //둘중 최대값 비교
    }
}