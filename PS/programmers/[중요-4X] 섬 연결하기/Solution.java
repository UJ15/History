import java.util.*;

class Solution {

    int[] parents;

    public int solution(int n, int[][] costs) {
        //cost순으로 정렬을 해준다. 크루스칼 알고리즘을 적용하기 위해 작은 간선순으로
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);

        //parents를 초기화해준다.
        parents = new int[n];

        //Node는 0부터 시작 -> 각자 자신이 부모가 되도록 초기화 해준다.
        //아직 최소 신장트리를 찾기 전
        for (int i = 0 ; i < n ; i++) {
            parents[i] = i;
        }

        //가중치의 합
        int total = 0;

        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];

            //from과 to의 부모를 가져온다. (같은 그래프인지 검사하는 것 == 연결되었는지)
            int fromParents = findParents(from);
            int toParents = findParents(to);

            //최소 신장 트리로 연결되어 있다면 continue;
            if (fromParents == toParents) {
                continue;
            }

            //가중치 더하기
            total += weight;
            //부모를 Union (최소 신장 트리로 연결)
            parents[toParents] = fromParents;
        }

        return total;
    }

    private int findParents(int node) {
        //자기 자신을 부모로 갖고 있다면 (루트 노드라면) == (Union의 대표 노드라면)
        if (parents[node] == node) {
            return node;
        }

        //아닐 경우 대표노드를 찾도록 재귀
        return parents[node] = findParents(parents[node]);
    }
}