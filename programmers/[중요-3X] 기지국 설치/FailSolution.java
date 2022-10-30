Time - OUT!!

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int num : stations) {
            baseCheck(visited, num - 1, w);
        }

        answer += newStation(visited, w);

        return answer;
    }

    private int newStation(boolean[] visited, int w) {
        int count = 0;

        for (int i = 0 ; i < visited.length ; i++) {
            if (!visited[i]) {
                int k = 0;
                for (int j = 0 ; j < 2 * w + 1 ; j++) {
                    if (j + i >= visited.length) {
                        break;
                    }
                    visited[j + i] = true;
                    k++;
                }
                i += k - 1;
                count++;
            }
        }

        return count;
    }

    private void baseCheck(boolean[] visited, int index, int w) {
        for (int i = index - w ; i <= index + w ; i++) {
            if (i < 0) {
                continue;
            }

            if (i >= visited.length) {
                break;
            }

            visited[i] = true;
        }
    }
}