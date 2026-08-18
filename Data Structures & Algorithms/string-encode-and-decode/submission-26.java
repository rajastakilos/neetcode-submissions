class Solution {
    private Character DELIMITER ='#';
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String string : strs) {
            sb.append(string.length()).append(DELIMITER).append(string);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int idx = 0;
        char[] buff = new char[256];
        while (idx < str.length()) {
            int position = idx;

            while (str.charAt(position) != DELIMITER) position++;

            // int length = Integer.parseInt(str.substring(idx, position));
            int length = 0;
            for (int p = idx; p < position; p++) {
                length = length * 10 + (str.charAt(p) - '0');
            }

            int start = position + 1;
            int end = start + length;

            if (length > buff.length) {
                buff = new char[length];
            }

            str.getChars(start, end, buff, 0);
            result.add(new String(buff, 0, length));

            idx = end;
        }

        return result;
    }
}
