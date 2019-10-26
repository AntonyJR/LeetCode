package medium.longestabsolutefilepath;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack=new ArrayDeque(20);
        String[] entries = input.split("\n");
        int level = -1;
        int maxPath = 1;
        int levelLen = 0;
        int prevLen = 0;

        for (String entry : entries) {
            int entryLen = entry.length();
            int newLevel;
            //noinspection StatementWithEmptyBody
            for(newLevel=0; newLevel<entryLen && entry.charAt(newLevel) == '\t'; newLevel++)
                ;
            int nameLen = entryLen-newLevel;
            nameLen++; // Adjust for /
            boolean file = entry.indexOf('.') > -1;
            if (file) {
                int filelevel = newLevel-1;
                while (filelevel < level) {
                    levelLen = prevLen;
                    prevLen = stack.pop();
                    level--;
                }
                maxPath = Math.max(maxPath, levelLen + nameLen);
            }
            else {
                if (newLevel > level) {
                    stack.push(prevLen);
                    prevLen = levelLen;
                    levelLen += nameLen;
                    level++;
                }
                else if (newLevel < level) {
                    while (newLevel < level) {
                        prevLen = stack.pop();
                        levelLen = prevLen+nameLen;
                        level--;
                    }
                }
                else {
                    levelLen = prevLen + nameLen;
                }
            }
        }
        return maxPath-1;
    }
}
