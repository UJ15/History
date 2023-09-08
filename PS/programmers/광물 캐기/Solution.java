import java.util.*;

class Solution {
    public static int result = Integer.MAX_VALUE;
    public static Map<String, int[]> piro = new HashMap<>();

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        piro.put("diamond", new int[]{ 1, 5, 25 });
        piro.put("iron", new int[]{ 1, 1, 5 });
        piro.put("stone", new int[]{ 1, 1, 1 });

        dfs(0, 0, picks, minerals);

        return result;
    }

    public void dfs(int index, int acc, int[] picks, String[] minerals) {
        if (index >= minerals.length || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            result = Math.min(result, acc);
            return;
        }


        for (int i = 0; i < 3; i++) {
            if(picks[i] == 0) continue;
            int idx = index;
            int temp_acc = acc;
            int[] temp_picks = Arrays.copyOf(picks, picks.length);
            temp_picks[i] -= 1;

            while (idx < minerals.length && idx < index + 5) {
                temp_acc += piro.get(minerals[idx])[i];
                idx++;
            }
            dfs(idx, temp_acc, temp_picks, minerals);
        }
    }
}

/**
 * Mine
 */
import java.util.*;

class Solution {
    private int result;
    private int[] mine;
    private int[] pick;
    private boolean[] visited;

    public int solution(int[] picks, String[] minerals) {
        result = Integer.MAX_VALUE;
        mine = new int[minerals.length];
        int n = picks[0] + picks[1] + picks[2];
        pick = new int[n];
        visited = new boolean[n];

        for (int i = 0 ; i < mine.length ; i++) {
            if (minerals[i].charAt(0) == 'd') {
                mine[i] = 25;
            }
            else if (minerals[i].charAt(0) == 'i') {
                mine[i] = 5;
            }
            else {
                mine[i] = 1;
            }
        }

        int index = 0;

        for (int i = 0 ; i < picks[0] ; i++) {
            pick[index] = 25;
            index++;
        }

        for (int i = 0 ; i < picks[1] ; i++) {
            pick[index] = 5;
            index++;
        }

        for (int i = 0 ; i < picks[2] ; i++) {
            pick[index] = 1;
            index++;
        }

        dfs(0, 0, 0);

        return result;
    }

    private void dfs(int depth, int stress, int mineIndex) {
        if (depth == pick.length) {
            result = Math.min(stress, result);
            return;
        }

        if (stress > result) {
            return;
        }

        for (int i = 0 ; i < pick.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;

                int add = 0;
                for (int j = 0 ; j < 5 ; j++) {
                    if (mineIndex + j == mine.length) {
                        result = Math.min(result, stress + add);
                        visited[i] = false;
                        return;
                    }
                    add += (int) Math.ceil((double) mine[mineIndex + j] / (double) pick[i]);
                }

                dfs(depth + 1, stress + add, mineIndex + 5);
                visited[i] = false;
            }
        }
    }
}