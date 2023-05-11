/**
 *
 * DFS 풀이 역시. 시간초과
 * 핵심은 현재 위치의 인덱스를 골랐을 경우 혹은 넘어갔을 경우의 수를 구하는 문제
 */

class Solution {
    private int result;

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        result = 0;

        dfs(nums1, nums2, 0, 0, 0);

        return result;
    }

    private void dfs(int[] nums1, int[] nums2, int index, int start, int edge) {
        if (index == nums1.length) {
            result = Math.max(result, edge);
            return;
        }

        for (int i = start ; i < nums2.length ; i++) {
            if (nums1[index] == nums2[i]) {
                dfs(nums1, nums2, index + 1, i + 1, edge + 1);
                break;
            }
        }

        dfs(nums1, nums2, index + 1, start, edge);
    }
}

/**
 * Second Try
 * 한 시퀀스에 하나의 nums1 원소를 모든 nums2요소가 검사한다.
 * 기존 값이 같다면 기존 dp에 + 1 다르다면 기존 dp와 이전 값중 큰값을 저장한다.
 * 그후 dp에 현재 까지의 dpRow기록을 복사한다.
 * 마지막 시퀀스까지 마치면 제일 마지막 값이 최대값이다.
 */

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];

        for (int i = 1 ; i <= nums1.length ; i++) {
            int[] dpRow = new int[nums2.length + 1];

            for (int j = 1; j <= nums2.length ; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dpRow[j] = dp[j - 1] + 1;
                } else {
                    dpRow[j] = Math.max(dp[j], dpRow[j - 1]);
                }
            }

            dp = dpRow;
        }

        return dp[nums2.length];
    }
}