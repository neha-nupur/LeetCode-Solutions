// // This is not working for long values at edge cases. 
// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int maxPile = 0;
//         for(int p : piles) {
//             maxPile = Math.max(maxPile, p);
//         }

//         // Try every possible speed
//         for(int k=1; k<=maxPile; k++){
//             long hrs = 0;
            
//             for(int pile: piles){
//                 hrs = hrs + (pile + k - 1)/k;
//             }

//             if(hrs <= h) {
//                 return k;
//             }
//         }
//         return -1;
//     }
// }


class Solution {

    public int minEatingSpeed(int[] piles, int hoursLimit) {

        int minSpeed = 1;
        int maxSpeed = 0;

        // Find the maximum pile (upper bound for speed)
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        // Binary search on eating speed
        while (minSpeed < maxSpeed) {

            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canFinishEating(piles, hoursLimit, midSpeed)) {
                maxSpeed = midSpeed;      // try slower speed
            } else {
                minSpeed = midSpeed + 1;  // need faster speed
            }
        }

        return minSpeed;
    }

    private boolean canFinishEating(int[] piles, int hoursLimit, int speed) {
        int totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed; // ceil(pile / speed)
        }

        return totalHours <= hoursLimit;
    }
}
