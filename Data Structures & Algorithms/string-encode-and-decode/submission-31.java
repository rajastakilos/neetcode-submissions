class Solution {
    private char D = '#';
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append(D).append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        // 6#rabbit3#cat
        int i = 0;
        while (i < str.length()) {
            int delimiter = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimiter));

            int start = delimiter + 1;
            int end = start + length;

            result.add(str.substring(start, end));
            i = end;
        }

        return result;
    }
}
