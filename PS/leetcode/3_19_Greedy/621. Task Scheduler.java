class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] feq = new int[26];

        for (int i = 0 ; i < tasks.length ; i++) {
            feq[tasks[i] - 'A']++;
        }

        Arrays.sort(feq);
        int max = feq[feq.length - 1];
        int count = 0;

        for (int f : feq) {
            if (f == max) {
                count++;
            }
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + count);
    }

}