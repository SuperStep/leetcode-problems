class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            // no cooling, just do the tasks one by one
            return tasks.length;
        }
        
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        Arrays.sort(frequencies);
        
        // max frequency
        int f_max = frequencies[25];
        int idle_time = (f_max - 1) * n;
        
        for (int i = frequencies.length - 2; i >= 0 && frequencies[i] > 0; i--) {
            idle_time -= Math.min(f_max - 1, frequencies[i]);
        }
        
        idle_time = Math.max(0, idle_time);
        
        return tasks.length + idle_time;
    }
}