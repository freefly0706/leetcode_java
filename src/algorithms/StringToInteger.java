/* -*- coding: UTF-8 -*- */
package algorithms;

public class StringToInteger {
    public int myAtoi(String str) {
        StringBuilder resultStr = new StringBuilder();
        int result;
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
            resultStr.append(str.charAt(i++));
        }
        if (resultStr.length() > 10 || (resultStr.length() == 10
                && (Integer.parseInt(resultStr.substring(0, 9)) > Integer.MAX_VALUE / 10 ||
                (Integer.parseInt(resultStr.substring(0, 9)) == Integer.MAX_VALUE / 10 &&
                        (resultStr.charAt(9) - '0' > Integer.MAX_VALUE % 10))))) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (resultStr.length() == 0) {
            return 0;
        }
        result = Integer.parseInt(resultStr.toString());
        return result * sign;
    }
}
