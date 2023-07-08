class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int prev = nums[0];

        for (int i = 0 ; i < nums.length ; i++) {
            if (prev != nums[i]) {
                list.add(nums[i]);
                prev = nums[i];
            }
        }

        for (int i = 0 ; i < list.size() ; i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }
}