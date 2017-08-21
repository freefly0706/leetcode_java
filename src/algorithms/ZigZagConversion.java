/* -*- coding: UTF-8 -*- */
package algorithms;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int stepInitial = (numRows - 1) * 2;
        for (int j = 0; j < s.length(); j += stepInitial) {
            result.append(s.charAt(j));
        }
        for (int i = 1, stepMid = stepInitial - 2; i < numRows - 1; i++, stepMid -= 2) {
            boolean isOdd = true;
            for (int j = i; j < s.length(); ) {
                if (isOdd) {
                    result.append(s.charAt(j));
                    j += stepMid;
                } else {
                    result.append(s.charAt(j));
                    j += 2 * i;
                }
                isOdd = !isOdd;
            }
        }
        for (int j = numRows - 1; j < s.length(); j += stepInitial) {
            result.append(s.charAt(j));
        }
        return result.toString();
    }
}
