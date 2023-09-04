class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char prev = s.charAt(0);

        for (int i = 1 ; i < s.length() ; i++) {
            if (prev > s.charAt(i)) {
                return decrease(s, i);
            }

            prev = s.charAt(i);
        }

        return n;
    }

    private int decrease(String s, int idx) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int changeIdx = 0;

        for (int i = idx ; i > 0 ; i--) {
            if (s.charAt(i - 1) < s.charAt(i)) {
                changeIdx = i;
                break;
            }
        }

        for (int i = 0 ; i < changeIdx ; i++) {
            sb.append(s.charAt(i));
        }

        sb.append(s.charAt(changeIdx) - '1');

        for (int i = changeIdx + 1 ; i < len ; i++) {
            sb.append('9');
        }

        return Integer.parseInt(sb.toString());
    }
}