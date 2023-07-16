class Solution {
    Map<Integer, Boolean> map;

    public boolean containsDuplicate(int[] nums) {
        map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, false);
            } else {
                return true;
            }

        }

        return false;
    }
}