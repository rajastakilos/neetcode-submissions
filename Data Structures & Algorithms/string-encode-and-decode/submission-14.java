class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Find delimiter
            int delimiterPosition = str.indexOf('#', i);
            // Find length
            int length = Integer.parseInt(str.substring(i, delimiterPosition));
            // Extract string
            int start = delimiterPosition + 1;
            int end = start + length;
            // add string to return
            result.add(str.substring(start, end));

            i = end;
        }

        return result;
    }
}
