class Solution {
    private int[] degree;

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        degree = new int[n];

        for (List<Integer> edge : edges) {
            degree[edge.get(1)]++;
        }

        for (int i = 0 ; i < n ; i++) {
            if (degree[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}