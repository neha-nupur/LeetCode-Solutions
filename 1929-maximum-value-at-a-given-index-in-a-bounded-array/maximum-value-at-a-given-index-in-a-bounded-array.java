class Solution {

    public int maxValue(int n, int index, int maxSum) {

        int start = 1;
        int end = maxSum;

        while (start < end) {
            int mid = start + (end - start + 1) / 2;

            if (isPossible(mid, n, index, maxSum)) {
                start = mid;        // try higher peak
            } else {
                end = mid - 1;      // peak too large
            }
        }

        return start;
    }

    private boolean isPossible(int peak, int n, int index, int maxSum) {

        long totalSum = peak;

        // LEFT SIDE
        int leftCount = index;
        int leftMin = Math.max(peak - leftCount, 1);
        long leftSum =
                (long)(peak - 1 + leftMin) * (peak - leftMin) / 2;

        int rightCount = n - index - 1;
        int rightMin = Math.max(peak - rightCount, 1);
        long rightSum =
                (long)(peak - 1 + rightMin) * (peak - rightMin) / 2;

        totalSum += leftSum + rightSum;

        totalSum += Math.max(0, leftCount - (peak - 1)) * 1L;
        totalSum += Math.max(0, rightCount - (peak - 1)) * 1L;

        return totalSum <= maxSum;
    }
}
