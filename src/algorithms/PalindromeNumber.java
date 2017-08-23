/* -*- coding: UTF-8 -*- */
package algorithms;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int reverseHalfX = 0;
        while (x > reverseHalfX) {
            reverseHalfX = reverseHalfX * 10 + x % 10;
            x /= 10;
        }
        return (x == reverseHalfX || x == reverseHalfX / 10);
    }
}
