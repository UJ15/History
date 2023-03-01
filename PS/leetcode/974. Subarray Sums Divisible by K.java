class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int [] remainderArray = new int[k];
        remainderArray[0] = 1;
        int sum = 0, count = 0;

        for(int num : nums){
            sum = (sum + num) % k;

            if (sum < 0) {
                sum += k;
            }

            count += remainderArray[sum];
            remainderArray[sum]++;
        }

        return count;
    }
}