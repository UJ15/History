class Solution {
    private List<List<Integer>> result;


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        result = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        int i = 0;
        int j = 0;

        while (result.size() < k) {
            result.add(Arrays.asList(nums1[i], nums2[j]));

            int nextI = Integer.MAX_VALUE;
            int nextJ = Integer.MAX_VALUE;

            if (i < len1 - 1) {
                nextI = nums1[i + 1] + nums2[j];
            }
            if (j < len2 - 1) {
                nextJ = nums1[i] + nums2[j + 1];
            }

            if (nextI == Integer.MAX_VALUE && nextJ == Integer.MAX_VALUE) {
                break;
            } else if (nextI > nextJ) {
                j++;
            } else {
                i++;
            }
        }

        return result;
    }
}