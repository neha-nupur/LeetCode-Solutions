// class Solution {
//     public int reachNumber(int target) {
//         target = Math.abs(target);   // symmetry
//         int sum = 0;
//         int step = 0;

//         while (sum < target || (sum - target) % 2 != 0) {
//             step++;
//             sum += step;
//         }
//         return step;
//     }
// }


class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);

        int k = (int) Math.ceil((Math.sqrt(1 + 8L * target) - 1) / 2);
        int sum = k * (k + 1) / 2;

        if ((sum - target) % 2 == 0) {
            return k;
        }

        // parity fix
        if ((k + 1) % 2 == 1) {
            return k + 1;
        } else {
            return k + 2;
        }
    }
}
