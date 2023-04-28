import java.util.*;
import java.util.Map.Entry;

class Solution {
    private Map<String, Integer> map;

    public String mostCommonWord(String paragraph, String[] banned) {
        map = new HashMap<>();
        paragraph = paragraph.replaceAll("[^A-Za-z ]", " ").toLowerCase();
        String result = "";
        String[] arr = paragraph.split(" ");
        List<String> ban = Arrays.asList(banned);

        for (String str : arr) {
            if (!ban.contains(str) && !str.equals("")) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        }).getKey();
    }
}