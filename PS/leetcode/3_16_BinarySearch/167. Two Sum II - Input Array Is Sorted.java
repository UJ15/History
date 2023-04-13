/**
 * two pointer
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }

        return null;
    }
}

/**
 * binary search
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0 ; i < numbers.length ; i++) {
            int n = target - numbers[i];
            int idx = binarySearch(n, numbers, i);

            if (idx != -1) {
                int[] result = new int[] {i + 1, idx + 1};
                Arrays.sort(result);
                return result;
            }
        }

        return null;
    }

    private int binarySearch(int target, int[] arr, int exclude) {
        int left = 0;
        int right = arr.length - 1;
        int mid = right / 2;

        while (left <= right) {
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                if (mid != exclude) {
                    return mid;
                } else {
                    break;
                }
            }

            mid = left + (right - left) / 2;
        }

        return -1;
    }
}
