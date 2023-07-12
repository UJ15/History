//내 풀이 속도 매우 느림 12ms
class Solution {
    private List<String> list;

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        list = new ArrayList<>();
        insertFirstString(strs[0]);

        for (int i = 1 ; i < strs.length ; i++) {
            compare(strs[i]);
        }

        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }

    private void compare(String s) {
        String[] split = s.split("");
        int len = list.size();

        for (int i = 0 ; i < split.length ; i++) {
            if (len > i) {
                if (!list.get(i).equals(split[i])) {
                    for (int j = i ; j < len ; j++) {
                        list.remove(i);
                    }
                    break;
                }
            }
        }
    }

    private void insertFirstString(String s) {
        String[] split = s.split("");

        for (int i = 0 ; i < split.length ; i++) {
            list.add(split[i]);
        }
    }
}

// simple

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        for (int i = 1 ; i < strs.length ; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
        }

        return result;
    }
}