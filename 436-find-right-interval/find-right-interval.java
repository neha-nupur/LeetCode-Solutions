class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        for(int i=0; i < n; i++){
            int end = intervals[i][1];
            int minStart = Integer.MAX_VALUE;
            int index = -1;

            for(int j=0; j<n; j++){
                if(intervals[j][0] >= end) {
                    if(intervals[j][0] < minStart){
                        minStart = intervals[j][0];
                        index = j;
                    }
                }
            }
            result[i] = index;
        }
        return result;
    }
}