/* -*- coding: UTF-8 -*- */
package algorithms.F1to50;

public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int y = x;
        while (y / 10 != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        if (y != 0) {
            if ((res * 10 + y) / 10 == res) {
                res = res * 10 + y;
            } else {
                return 0;
            }
        }
        return res;
    }
}
