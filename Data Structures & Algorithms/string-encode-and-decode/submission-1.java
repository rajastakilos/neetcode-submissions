class Solution {

    public String encode(List<String> strs) {
        String delimiter = "#";
        StringBuilder encodingStringBuilder = new StringBuilder("");
        for (String string : strs) {
            encodingStringBuilder.append(string.length() + delimiter + string);
        }

        return encodingStringBuilder.toString();
    }

    public List<String> decode(String str) {

        // 5#hello#5#world#
        List<String> decodedStringList = new ArrayList<>();
        char[] characters = str.toCharArray();
        char delimiter = '#';
        // 5#hello5#world
        int i = 0;
        while (i < characters.length) {
            StringBuilder lengthString = new StringBuilder("");
            while (characters[i] != delimiter) {
                lengthString.append(characters[i++]);
            }

            i++; // Skip #

            int length = Integer.parseInt(lengthString.toString());

            StringBuilder decoded = new StringBuilder("");
            while (length > 0) {
                decoded.append(characters[i++]);
                length--;                
            }

            decodedStringList.add(decoded.toString());
        }
        
        return decodedStringList;
    }
}
