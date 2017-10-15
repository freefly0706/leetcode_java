/* -*- coding: UTF-8 -*- */
package algorithms.one2fifty;

public class StringToInteger {
    public int myAtoi(String str) {
        long result = 0;
        int sign = 1;
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }
        if (i == str.length()) {
            return 0;
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        while (i < str.length() && '0' <= str.charAt(i) && str.charAt(i) <= '9') {
            int digit = str.charAt(i++) - '0';
            result = result * 10 + digit;
            if (result > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int) result * sign;
    }
}
