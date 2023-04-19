
//내 풀이
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> q = new ArrayDeque<>();
        Deque<Character> rq = new ArrayDeque<>();
        int maxLen = 100001;

        //해시맵에 해당하는 키값 추가
        for (int i = 0 ; i < t.length() ; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0 ; i < s.length() ; i++) {
            Character c = s.charAt(i);

            //윈도우에 삽입
            q.addLast(c);
            //t에 존재하는 문자일때 해시맵에서 해당 키값 감소
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }

            //윈도우 앞에서부터 줄이기
            while (isIncludeAll(map)) {
                if (maxLen > q.size()) {
                    maxLen = q.size();
                    rq = new ArrayDeque(q);
                }

                char r = q.removeFirst();
                if (map.containsKey(r)) {
                    map.put(r, map.get(r) + 1);
                    //중복값 처리
          리         while (!q.isEmpty() && r == q.peekFirst() && map.get(r) < 0) {
                        q.removeFirst();
                        map.put(r, map.get(r) + 1);
                    }
                }
            }
        }

        if (maxLen == 100001) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (char a : rq) {
            sb.append(a);
        }

        return sb.toString();
    }

    //해시맵 모든 값이 0 이하면 모든 문자 포함
    private boolean isIncludeAll(Map<Character, Integer> map) {
        return map.entrySet().stream().filter(e -> e.getValue() > 0).count() == 0;
    }
}

//굳이 덱 사용할필요 없다. 투포인터 이용하면 됨
class Solution {
    public String minWindow(String s, String t) {
        int len = s.length() + 1;
        String ans = "";
        HashMap<Character,Integer> map = new HashMap();
        for (int i = 0 ; i < t.length() ; i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i),1);
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }
        }

        int i = 0;
        int j = 0;
        int count = map.size();

        while (j<s.length()){
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }

            while(count == 0) {
                if (j - i + 1 < len) {
                    len = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i))==1) {
                        count += 1;
                    }
                }
                i++;
            }
            j++;
        }

        return ans;
    }
}