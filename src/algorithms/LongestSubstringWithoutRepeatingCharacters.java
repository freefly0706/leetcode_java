package algorithms;

import java.util.*;

/**
 * Created by fly on 8/14/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int q = 0;  //用来记录与当前所遍历的字符重复的字符下标
        int count = 0;  //用来记录s[q]之后非重复字符数
        Map<Character, Integer> temp = new HashMap<>();
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            if (temp.containsKey(s.charAt(i))) {
                maxLength = Math.max(count,maxLength);
                q = Math.max(temp.get(s.charAt(i)), q);
                count = i - q;
            }
            count++;
            temp.put(s.charAt(i), i + 1);
        }
        maxLength = Math.max(count,maxLength); //防止s中只有一个字符
        return maxLength;
    }
}
