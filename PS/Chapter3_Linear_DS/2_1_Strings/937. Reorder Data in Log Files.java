//https://leetcode.com/problems/reorder-data-in-log-files/description/

class Solution {
    List<String> letters;
    List<String> digits;
    public String[] reorderLogFiles(String[] logs) {
        letters = new ArrayList<>();
        digits = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.charAt(log.length() - 1))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }

        letterLogSort(letters);

        for (String digit : digits) {
            letters.add(digit);
        }

        return letters.toArray(new String[letters.size()]);
    }

    private void letterLogSort(List<String> letters) {
        letters.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1Arr = s1.split(" ");
                String[] s2Arr = s2.split(" ");
                String body1 = makeBody(s1Arr);
                String body2 = makeBody(s2Arr);

                if (body1.compareTo(body2) == 0) {
                    return s1Arr[0].compareTo(s2Arr[0]);
                }

                return body1.compareTo(body2);
            }
        });
    }

    private String makeBody(String[] letters) {
        String result = "";

        for (int i = 1 ; i < letters.length ; i++) {
            result += letters[i] + " ";
        }

        return result;
    }
}