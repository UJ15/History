import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        double intersection = 0;

        for (int i = 0 ; i < str1.length() -1 ; i++) {
            String element = str1.substring(i, i + 2);

            if (!element.matches("(.*)[^a-zA-Z](.*)")) {
                list.add(element);
            }
        }

        for (int i = 0 ; i < str2.length() - 1 ; i++) {
            String element = str2.substring(i, i + 2);

            if (!element.matches("(.*)[^a-zA-Z](.*)")) {
                if (list.contains(element)) {
                    list.remove(element);
                    intersection++;
                }

                list2.add(element);
            }
        }

        double union = list.size() + list2.size();

        if (union == 0) {
            return 65536;
        }

        return (int) ((intersection / union) * 65536);
    }
}