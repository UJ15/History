import java.util.*;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> num1 = new HashSet<>();
        Set<Integer> num2 = new HashSet<>();

        for (int num : nums1) {
            num1.add(num);
        }

        for (int num : nums2) {
            num2.add(num);
        }


        for (int num : num1) {
            if (!num2.contains(num)) {
                list1.add(num);
            }
        }

        for (int num : num2) {
            if (!num1.contains(num)) {
                list2.add(num);
            }
        }

        result.add(list1);
        result.add(list2);

        return result;
    }
}