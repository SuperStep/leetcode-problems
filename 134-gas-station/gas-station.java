class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int total = 0;
        int remaining = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            remaining += diff;

            if (remaining < 0) {
                start = i + 1;
                remaining = 0;
            }
        }

        return total >= 0 ? start : -1;
    }
}