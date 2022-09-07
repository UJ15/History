import java.util.HashMap;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        int result = 0;
        
        for (int i = 0; i < jewels.length() ; i++){
            freq.put(jewels.charAt(i), 0);
        }

        
        for (int i = 0 ; i < stones.length() ; i++){
            if (freq.containsKey(stones.charAt(i))){
                freq.replace(stones.charAt(i), freq.get(stones.charAt(i)) + 1);
            }
        }
        
        for (Character key : freq.keySet()){
            result += freq.get(key);
        }

        return result;
    }
}

