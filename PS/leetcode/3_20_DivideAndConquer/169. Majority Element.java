/**
 *  My Solution
 */
class Solution {
    private int result = 0;
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map.entrySet().forEach(e -> {
            if (e.getValue() > half) {
                result = e.getKey();
            }
        });

        return result;
    }
}

/**
 * Super Simple
 */

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/**
 * Divide and Conquer
 * Best Speed
 */

class Solution {
    public int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    //인덱스로 배열을 나누고 등장 빈도가 가장 높은 값을 반환한다.
    private int divideAndConquer(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = start + (end - start) / 2;

        int left = divideAndConquer(nums, start, mid);
        int right = divideAndConquer(nums, mid + 1, end);

        if (left == right) {
            return left;
        }

        int leftCount = freq(nums, left, start, mid);
        int rightCount = freq(nums, right, mid + 1, end);

        return leftCount > rightCount ? left : right;
    }

    private int freq(int[] nums, int element, int start, int end) {
        int count = 0;

        for (int i = start ; i <= end ; i++) {
            if (nums[i] == element) {
                count++;
            }
        }

        return count;
    }
}