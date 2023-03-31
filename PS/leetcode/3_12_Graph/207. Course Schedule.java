import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] degree = new int[numCourses];
        List<Integer> bfs = new ArrayList<>();

        for (int i = 0 ; i < graph.length ; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
            degree[e[0]]++;
        }

        for (int i = 0 ; i < numCourses ; i++) {
            if (degree[i] == 0) {
                bfs.add(i);
            }
        }

        for (int i = 0 ; i < bfs.size() ; i++) {
            for (int j : graph[bfs.get(i)]) {
                if (--degree[j] == 0) {
                    bfs.add(j);
                }
            }
        }

        return bfs.size() == numCourses;
    }
}