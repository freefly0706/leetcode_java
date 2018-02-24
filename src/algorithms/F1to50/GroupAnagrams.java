package algorithms.F1to50;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /*
     * In Java, the hashTable representation of our count will be a string delimited with '#' characters.
     * For example, abbccc will be #1#2#3#0#0#0...#0 where there are 26 entries total.
     * In python, the representation will be a tuple of the counts.
     * For example, abbccc will be (1, 2, 3, 0, 0, ..., 0), where again there are 26 entries total.
     * */
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//        int[] count = new int[26];
//        for (String str : strs) {
//            Arrays.fill(count, 0);
//            for (char ch : str.toCharArray()) {
//                count[ch - 'a']++;
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < 26; i++) {
//                sb.append('#').append(count[i]);
//            }
//            String key = sb.toString();
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(str);
//        }
//        return new ArrayList<>(map.values());
//    }
}
