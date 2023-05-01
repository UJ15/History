class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        int count = 0;

        for (int i = 1 ; i < salary.length - 1 ; i++) {
            sum += salary[i];
            count++;
        }

        return Math.round((double) sum / (double) count * 100000) / 100000.0;
    }
}