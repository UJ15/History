class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int start = 0;
        int tank = 0;

        for (int i = 0 ; i < gas.length ; i++) {
            if (tank + gas[i] < cost[i]) {
                start = i + 1;
                tank = 0;
            } else {
                tank += gas[i] - cost[i];
            }
        }

        return start;
    }
}