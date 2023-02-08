import java.util.*;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0 ; i < stones.length() ; i++) {
            map.put(stones.charAt(i), map.getOrDefault(stones.charAt(i), 0) + 1);
        }

        for (int i = 0 ; i < jewels.length() ; i++) {
            if (map.containsKey(jewels.charAt(i))) {
                result += map.get(jewels.charAt(i));
            }
        }

        return result;
    }
}