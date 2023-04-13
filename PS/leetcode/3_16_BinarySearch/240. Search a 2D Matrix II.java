class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lastRow = matrix[0].length - 1;

        for (int i = 0 ; i < matrix.length ; i++) {
            if (matrix[i][lastRow] < target) {
                continue;
            }

            if (binarySearch(target, matrix[i])) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = right / 2;

        while (left <= right) {
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }

            mid = left + (right - left) / 2;
        }

        return false;
    }
}