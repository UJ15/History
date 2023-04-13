class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        String bin = Integer.toBinaryString(xor);
        int count = 0;

        for (int i = 0 ; i < bin.length() ; i++) {
            if (bin.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
}