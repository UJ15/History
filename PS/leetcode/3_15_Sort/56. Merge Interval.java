class Solution {
    private boolean[] field;

    public int[][] merge(int[][] intervals) {
        field = new boolean[10001];
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = -1;
        int end = -1;

        for (int interval[] : intervals) {
            if (!field[interval[0]]) {
                list.add(new int[] {start, end});

                start = interval[0];
                end = interval[1];

                for (int i = start ; i <= end ; i++) {
                    field[i] = true;
                }
            } else {
                for (int i = end ; i <= interval[1] ; i++) {
                    field[i] = true;
                }
                end = Math.max(interval[1], end);
            }
        }

        list.add(new int[] {start, end});
        int[][] result = new int[list.size() - 1][2];

        for (int i = 1 ; i < list.size() ; i++) {
            int[] arr = list.get(i);

            for (int j = 0 ; j < 2 ; j++) {
                result[i - 1][j] = arr[j];
            }
        }

        return result;
    }
}

