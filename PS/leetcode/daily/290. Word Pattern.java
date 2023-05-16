class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }

        for (int i = 0 ; i < arr.length ; i++) {
            if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(arr[i])) {
                map.put(pattern.charAt(i), arr[i]);
            }
        }

        for (int i = 0 ; i < arr.length ; i++) {
            if (!map.containsKey(pattern.charAt(i)) || !map.get(pattern.charAt(i)).equals(arr[i])) {
                return false;
            }
        }

        return true;
    }
}