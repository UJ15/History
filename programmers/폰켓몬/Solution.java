https://school.programmers.co.kr/learn/courses/30/lessons/1845

public class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;

        HashSet<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
        }

        if (numsSet.size() > max) {
            return max;
        }

        return numsSet.size();
    }
}