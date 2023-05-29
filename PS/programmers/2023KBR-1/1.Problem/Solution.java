import java.util.*;

class Solution {
    Map<String, Integer> map;

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        saveTerm(terms);
        int todays = dateToDays(today);
        int num = 1;

        for (String p : privacies) {
            String[] info = p.split(" ");
            int createdAt = dateToDays(info[0]);
            if (createdAt + map.get(info[1]) <= todays) {
                result.add(num);
            }
            num++;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private void saveTerm(String[] terms) {
        map = new HashMap<>();

        for (String term : terms) {
            String[] info = term.split(" ");

            map.put(info[0], Integer.parseInt(info[1]) * 28);
        }
    }

    private int dateToDays (String date) {
        int result = 0;
        String[] info = date.split("\\.");

        result += Integer.parseInt(info[0]) * 12 * 28;
        result += Integer.parseInt(info[1]) * 28;
        result += Integer.parseInt(info[2]);

        return result;
    }
}