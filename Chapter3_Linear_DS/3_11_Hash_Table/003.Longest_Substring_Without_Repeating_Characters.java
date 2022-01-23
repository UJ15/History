
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> h = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;
        
        while (end < s.length()){
            if (!h.contains(s.charAt(end))){
                h.add(s.charAt(end));
                end++;
                max = Math.max(max, h.size());
            }
            else{
                h.remove(s.charAt(start));
                start++;
            }
        }
        
        return max;
    }
}

