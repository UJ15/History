class Solution {
    public int minFlipsMonoIncr(String s) {

        int flips = 0
        int ones = 0;
        int i = 0;

        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        for (; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                flips++;
            } else {
                ones++;
            }

            if (flips > ones) {
                flips = ones;
            }
        }

        return flips;
    }
}