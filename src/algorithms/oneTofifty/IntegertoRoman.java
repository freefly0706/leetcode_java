/* -*- coding: UTF-8 -*- */
package algorithms.oneTofifty;

public class IntegertoRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        String[] baseString = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] baseInt = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < baseString.length; i++) {
            while (num >= baseInt[i]) {
                if (num >= baseInt[i]) {
                    res.append(baseString[i]);
                    num -= baseInt[i];
                }
            }
        }
        return res.toString();
    }
}
