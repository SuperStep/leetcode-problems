class Solution {
    public int findMinArrowShots(int[][] points) {
if (points.length == 0) {
            return 0;
        }
        
        // Sort the points based on the ending x-coordinate
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        
        int arrowCount = 1; // We need at least one arrow to start
        int arrowLimit = points[0][1]; // The end coordinate of the first balloon
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowLimit) {
                // If the start of the current balloon is beyond the current arrow's limit,
                // we need a new arrow
                arrowCount++;
                arrowLimit = points[i][1];
            }
            // Otherwise, the current arrow is enough to burst this balloon
        }
        
        return arrowCount;
    }
}