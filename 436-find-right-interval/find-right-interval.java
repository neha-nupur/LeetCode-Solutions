// //Brute Force Solution

// class Solution {
//     public int[] findRightInterval(int[][] intervals) {
//         int n = intervals.length;
//         int[] result = new int[n];

//         for(int i=0; i < n; i++){
//             int end = intervals[i][1];
//             int minStart = Integer.MAX_VALUE;
//             int index = -1;

//             for(int j=0; j<n; j++){
//                 if(intervals[j][0] >= end) {
//                     if(intervals[j][0] < minStart){
//                         minStart = intervals[j][0];
//                         index = j;
//                     }
//                 }
//             }
//             result[i] = index;
//         }
//         return result;
//     }
// }

//Optimized Solution 

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            map.put(intervals[i][0], i);
        }

        Arrays.sort(starts);

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int idx = lowerBound(starts, end);

            if (idx == n) result[i] = -1;
            else result[i] = map.get(starts[idx]);
        }

        return result;
    }

    //binary search function
    private int lowerBound(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return s;
    }
}
