class Solution {
    private Character DELIMITER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String s : strs) sb.append(s.length()).append(DELIMITER).append(s);
        
        return sb.toString();
    }
    // 6#rabbit7#rabbits

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int delimiterPosition = i;
            while (str.charAt(delimiterPosition) != DELIMITER) delimiterPosition++;

            Integer length = Integer.parseInt(str.substring(i, delimiterPosition));
            int start = delimiterPosition + 1;
            int end = start + length;

            result.add(str.substring(start, end));
            i = end;
        }

        return result;
    }
}
