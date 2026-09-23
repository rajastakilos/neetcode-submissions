class Solution {
    public int lengthOfLastWord(String s) {
        int lastSpace = 0;
        int lengthOfLastWord = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && 
                s.charAt(i + 1) != ' ') lastSpace = i;
        }

        for (int i = lastSpace; i < s.length(); i++) {
            if (s.charAt(i) != ' ') lengthOfLastWord++;
        } 

        return lengthOfLastWord;
    }
}