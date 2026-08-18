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
        int i = 0;
        // 6#rabbit
        while (i < str.length()) {
            int delimiterPosition = i;
            // Find the delimiter
            while (str.charAt(delimiterPosition) != '#') delimiterPosition++;
            // Find the length
            Integer length = Integer.parseInt(str.substring(i, delimiterPosition));
            int start = delimiterPosition + 1;
            int end = start + length;
            result.add(str.substring(start, end));

            i = end;
        }

        return result;
    }
}
