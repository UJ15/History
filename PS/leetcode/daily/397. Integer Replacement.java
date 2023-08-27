class Solution {
    public int integerReplacement(int n) {
        int result = 0;
        long t = (long) n;

        while (t != 1) {
            if (t % 2 == 0) {
                t /= 2;
            } else {
                long temp = (t - 1) / 2;
                if (temp == 1 || temp % 2 == 0) {
                    t -= 1;
                } else {
                    t += 1;
                }
            }

            result++;
        }

        return result;
    }
}