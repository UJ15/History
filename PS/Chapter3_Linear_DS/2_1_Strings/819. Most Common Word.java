//https://leetcode.com/problems/most-common-word/description/

/*
    1. 문자열을 소문자로 변환 후 제거대상을 기호들을 제거한다.
    2. split을 이용해 공백단위로 문자열 배열을 만든다.
    3. 공백과 빈문자열을 제외한 단어들의 개수를 HashMap에 저장한다.
    4. 빈도수를 사용해 정렬 후 금지문자가 아닌 최다빈도 단어를 반환한다.
*/

import java.util.*;

class Solution {
    Map<String, Integer> map;

    public String mostCommonWord(String paragraph, String[] banned) {
        map = new HashMap<>();

        mapInit(paragraph.toLowerCase().replaceAll("[!?`',;.]", " "));

        return getWord(banned);
    }

    private String getWord(String[] banned) {
        String answer = "";

        List<Map.Entry<String, Integer>> entries = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : entries) {
            if (!Arrays.asList(banned).contains(entry.getKey())) {
                answer = entry.getKey();
                return answer;
            }
        }

        return answer;
    }

    private void mapInit(String paragraph) {
        String[] arr = paragraph.split(" ");

        for (String str : arr) {
            if (str.equals(" ") || str.equals("")) {
                continue;
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
    }
}