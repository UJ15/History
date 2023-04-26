class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            num = sum(num);
        }

        return num;
    }

    private int sum(int num) {
        int sum = 0;
        while (num > 9) {
            sum += num % 10;
            num /= 10;
        }

        return sum + num;
    }
}