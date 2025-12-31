class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers & numbers ending with 0 (except 0)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;

        // Reverse half of the number
        while (x > rev) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }

        // Compare halves
        // For even length: x == rev
        // For odd length: x == rev / 10
        return (x == rev || x == rev / 10);
    }
}
