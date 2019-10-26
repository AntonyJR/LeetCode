package medium.groupanagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key,list);
            }

            list.add(s);
            //map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
