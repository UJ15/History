class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int prev = nums[0];

        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] - prev != 1) {
                addRanges(result, nums[i - 1], start);
                start = nums[i];
            }

            prev = nums[i];
        }

        addRanges(result, prev, start);

        return result;
    }

    private void addRanges(List<String> result, int end, int start) {
        if (start == end) {
            result.add(String.valueOf(end));
        } else {
            result.add(start + "->" + end);
        }
    }
}