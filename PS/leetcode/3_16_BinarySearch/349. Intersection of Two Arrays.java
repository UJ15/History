class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) {
            if (bs(num, nums2)) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean bs(int n, int[] arr) {
        int right = arr.length - 1;
        int left = 0;
        int mid = right / 2;

        while (left <= right) {
            if (arr[mid] < n) {
                left = mid + 1;
            } else if (arr[mid] > n) {
                right = mid - 1;
            } else {
                return true;
            }

            mid = left + (right - left) / 2;
        }

        return false;
    }
}