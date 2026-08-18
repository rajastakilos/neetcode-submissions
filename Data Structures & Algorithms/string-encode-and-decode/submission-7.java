class Solution {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strs) {
            stringBuilder.append(string.length()).append('#').append(string);
        }
        
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;

        // Check length of whole string; 
        while (i < str.length()) {
            // Find delimiter. 
            int delimiterPosition = i;
            while (str.charAt(delimiterPosition) != '#') delimiterPosition++;

            // Find length.
            int length = Integer.parseInt(str.substring(i, delimiterPosition));

            // Move pointer
            int start = delimiterPosition + 1;
            int end = start + length;

            decodedStrings.add(str.substring(start, end));

            i = end;
        }
        
        return decodedStrings;
    }
}
