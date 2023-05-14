class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            digits = roundUp(digits);
        }

        return digits;
    }

    private int[] roundUp(int[] digits) {
        int plus = 1;

        for (int i = digits.length - 1 ; i >= 0 ; i--) {
            if (i == 0 && digits[i] + plus == 10) {
                int[] nDigits = new int[digits.length + 1];
                nDigits[0] = 1;
                return nDigits;
            }

            if (digits[i] + plus == 10) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        return digits;
    }
}