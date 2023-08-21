class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        if (num < 2) {
            return false;
        }

        for (int i = 2 ; i * i <= num ; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }

        return sum == num;
    }
}