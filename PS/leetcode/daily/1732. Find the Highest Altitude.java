class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int[] sumArray = new int[gain.length + 1];

        for (int i = 1 ; i < sumArray.length ; i++) {
            sumArray[i] = sumArray[i - 1] + gain[i - 1];
            max = Math.max(max, sumArray[i]);
        }

        return max;
    }
}