//https://leetcode.com/problems/group-anagrams/description/

/*
1. 문자열을 정렬한 Key값을 map에 저장하고 해당 value인 리스트에 Key값이 같은 문자열을 추가해준다.
2. map의 value들을 리스트로 반환한다.
 */

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}