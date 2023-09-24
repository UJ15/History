class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) {
            return 0;
        }

        List<Double> prevRow = new ArrayList<>(List.of((double) poured));

        while (query_row-- > 0) {
            List<Double> currentRow = new ArrayList<Double>();
            double champagneInEnds = Math.max(0, (prevRow.get(0) - 1) / 2);

            currentRow.add(champagneInEnds);

            for (int i = 1 ; i < prevRow.size() ; i++) {
                currentRow.add(Math.max(0, (prevRow.get(i - 1) - 1) / 2) + Math.max(0, (prevRow.get(i) - 1) / 2));
            }

            currentRow.add(champagneInEnds);
            prevRow = currentRow;

        }

        return Math.min(1, prevRow.get(query_glass));
    }
}