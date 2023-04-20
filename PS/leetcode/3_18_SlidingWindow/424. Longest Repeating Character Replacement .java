class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[128];
        int result = 0;
        int maxLen = -1;

        for (int i = 0 ; i < s.length() ; i++) {
            maxLen = Math.max(maxLen, ++count[s.charAt(i)]);
            if (result - maxLen < k) {
                result++;
            } else {
                count[s.charAt(i - result)]--;
            }
        }

        return result;
    }
}

/**
 * 내가 시도한 방법
 * - 배열 쓰면 되는데 굳이 해시맵 쓰려는 버릇을 고쳐보자
 *
 */

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = -1;
        int result = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            map.put(s.charAt(i), 0);
        }

        for (int i = 0 ; i < s.length() ; i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            maxLen = Math.max(maxLen, map.get(s.charAt(i)));

            if (result - maxLen < k) {
                result++;
            } else {
                map.put(s.charAt(i - result), map.get(s.charAt(i - result)) - 1);
            }
        }

        return result;
    }
}