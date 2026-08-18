class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int strIndex = 0;
        // 6#rabbit
        while (strIndex < str.length()) {
            int delimiterPosition = strIndex;
            // Find the delimiter
            while (str.charAt(delimiterPosition) != '#') delimiterPosition++;
            // Find the length
            Integer length = Integer.parseInt(str.substring(strIndex, delimiterPosition));
            int start = delimiterPosition + 1;
            int end = start + length;
            result.add(str.substring(start, end));
            // Moe stringIndex to end of the current string.
            strIndex = end;
        }

        return result;
    }
}
