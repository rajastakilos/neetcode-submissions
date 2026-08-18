class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s: strs) res.append(s.length()).append('#').append(s);
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // 1. Find the delimiter
            int delimiterPos = i;
            while (str.charAt(delimiterPos) != '#') delimiterPos++;

            // 2. Parse length from before the delimiter.
            int length = Integer.parseInt(str.substring(i, delimiterPos));

            // 3. Move pointer to the start of the actual string
            int strStart = delimiterPos + 1;
            int strEnd = strStart + length;

            // 4. Extract string
            res.add(str.substring(strStart, strEnd));

            // 5. Move pointer i to the beginning of the new word
            i = strEnd;
        }


        return res;
    }
}
