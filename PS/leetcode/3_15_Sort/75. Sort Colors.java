class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int l = nums.length;
        int mid = 1;

        while (j < l) {
            if (nums[j] < mid) {
                swap(j, i, nums);
                i++;
                j++;
            } else if (nums[j] > mid) {
                l--;
                swap(j, l, nums);
            } else {
                j++;
            }
        }
    }

    private void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}