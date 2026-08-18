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

        int i = 0;
        while (i < str.length()) {
            int position = i;

            while (str.charAt(position) != DELIMITER) position++;
            int length = Integer.parseInt(str.substring(i, position));
            int start = position + 1;
            int end = start + length;
            result.add(str.substring(start, end));

            i = end;
        }

        return result;
    }
}
