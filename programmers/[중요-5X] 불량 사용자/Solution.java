https://school.programmers.co.kr/learn/courses/30/lessons/64064

import java.util.*;

class Solution {
    private Set<String> set;
    private String[] userId;
    private String[] bannedId;
    private boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        userId = user_id;
        visited = new boolean[userId.length];
        bannedId = new String[banned_id.length];

        for (int i = 0 ; i < banned_id.length ; i++) {
            bannedId[i] = banned_id[i].replaceAll("\\*", ".");
        }

        dfs(0, "");

        return set.size();
    }

    private void dfs(int depth, String banUsers) {
        if (depth == bannedId.length) {
            String[] names = banUsers.split(" ");
            Arrays.sort(names);

            String data = "";
            for (String name : names) {
                data += name;
            }

            set.add(data);
            return;
        }

        for (int i = 0 ; i < userId.length ; i++) {
            if (!visited[i] && userId[i].matches(bannedId[depth])) {
                visited[i] = true;
                dfs(depth + 1, banUsers + " " + userId[i]);
                visited[i] = false;
            }
        }
    };
}