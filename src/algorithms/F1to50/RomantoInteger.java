/* -*- coding: UTF-8 -*- */
package algorithms.F1to50;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> base = new HashMap<>();
        base.put('I', 1);
        base.put('V', 5);
        base.put('X', 10);
        base.put('L', 50);
        base.put('C', 100);
        base.put('D', 500);
        base.put('M', 1000);
        int i = 0;
        while (i < s.length() - 1) {
            if (base.get(s.charAt(i)) < base.get(s.charAt(i + 1))) {
                res += base.get(s.charAt(i + 1)) - base.get(s.charAt(i));
                i += 2;
            } else {
                res += base.get(s.charAt(i));
                i++;
            }
        }
        if (i == s.length() - 1) {
            res += base.get(s.charAt(i));
        }
        return res;
    }
}
