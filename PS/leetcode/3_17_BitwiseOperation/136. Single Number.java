/**
 * XOR 연산을 활용한 풀이
 * 2번 나오는 값은 다시 0으로 초기화 될것이고
 * 한 번 나오는 값은 그 값을 그대로 갖고 있을것
 * 아름답다.
 */

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}