class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        for (int i = 0 ; i < tc.length ; i++) {
            if (sc.length != tc.length || sc[i] != tc[i]) {
                return false;
            }
        }

        return true;
    }
}