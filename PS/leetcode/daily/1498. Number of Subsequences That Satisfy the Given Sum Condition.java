/**
 * 부분집합의 개수를 사용해야하는 문제다.
 * n개의 원소에 대한 부분집합의 개수는 2의 n제곱이다.
 * 그러므로 처음에 주어지는 배열 길이에 맞게 각 배열 길이당 갖는 부분집합의 개수를 구해준다. (pow[])
 * 배열을 정렬한 후 투포인터를 활용하여 최소값과 최대값이 target보다 작다면 해당 원소를 포함한 모든 부분집합 개수를 더해주고 왼쪽포인터를 올려주고
 * target보다 크다면 오른쪽 포인터를 감소시킨다.
 * 알면 쉬운데 모르면 절대못푸는 문제..
 */


class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        int[] pow = new int[nums.length];
        pow[0] = 1;

        for (int i = 1 ; i < pow.length ; i++) {
            pow[i] = pow[i - 1] * 2 % 1000000007;
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow[right - left]) % 1000000007;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}