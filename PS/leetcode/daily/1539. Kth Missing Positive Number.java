import java.util.*;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingStartNumber = 1;
        int between = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            between = arr[i] - missingStartNumber;
            k -= between;

            if (k <= 0) {
                return missingStartNumber + between - Math.abs(k) - 1;
            }

            missingStartNumber = arr[i] + 1;
        }

        return missingStartNumber + k - 1;
    }
}