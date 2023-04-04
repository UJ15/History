/**
 * 순환이 없는 그래프에서 각 노드를 루트로 가정할때 최소 높이 트리를 구하는 알고리즘은
 * 리프노드를 지우면서 마지막에 남아있는 노드가 루트가 될때 최소 높이 트리가 된다.
 *
 * 인접리스트의 크기가 1인 (리프노드)노드를 제거하면서 마지막에 남은 노드를 반환해주면 된다.
 * leaves 라는 리스트에 지워질 노드를 저장하고 그래프에서 지워주는게 핵심 코드
 */

class Solution {
    private List<Integer>[] graph;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        List<Integer> leaves = new ArrayList<>();

        createGraph(n, edges);

        for (int i = 0 ; i < n ; i++) {
            if (graph[i].size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            int size = leaves.size();

            for (int i = 0 ; i < size ; i++) {
                int value = leaves.remove(0);
                for (int node : graph[value]) {
                    graph[node].remove(Integer.valueOf(value));

                    if (graph[node].size() == 1) {
                        newLeaves.add(node);
                    }
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }

    private void createGraph(int n, int[][] edges) {
        graph = new List[n];

        for (int i = 0 ; i < n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }
}