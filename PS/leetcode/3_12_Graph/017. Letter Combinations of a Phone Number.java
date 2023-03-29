import java.util.*;

class Solution {
    Map<String, List<Character>> map;
    List<String> answer;

    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        answer = new ArrayList<>();
        createMap();
        String[] number = digits.split("");

        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        dfs("", digits.length(), 0, number);
        return answer;
    }

    private void dfs(String str, int len, int num, String[] number) {
        if (str.length() == len) {
            answer.add(str);
            return;
        }

        List<Character> letters = map.get(number[num]);

        for (char letter : letters) {
            dfs(str + letter, len, num + 1, number);
        }
    }

    private void createMap() {
        map.put("2", List.of('a','b','c'));
        map.put("3", List.of('d','e','f'));
        map.put("4", List.of('g','h','i'));
        map.put("5", List.of('j','k','l'));
        map.put("6", List.of('m','n','o'));
        map.put("7", List.of('p','q','r','s'));
        map.put("8", List.of('t','u','v'));
        map.put("9", List.of('w','x','y','z'));
    }
}