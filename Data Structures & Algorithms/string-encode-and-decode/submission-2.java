class Solution {

    public String encode(List<String> strs) {
        String delimiter = "#";
        StringBuilder encodingStringBuilder = new StringBuilder();
        for (String string : strs) {
            encodingStringBuilder // + concatenation creates new Strings.
                .append(string.length())
                .append(delimiter)
                .append(string);
        }

        return encodingStringBuilder.toString();
    }

    public List<String> decode(String str) {

        // 5#hello#5#world#
        List<String> decodedStringList = new ArrayList<>();
        char[] characters = str.toCharArray();
        char delimiter = '#';

        int i = 0;
        // Note: len = len * 10 + (characters[i] - '0'); instead of StringBuilder.
        while (i < characters.length) {
            StringBuilder lengthString = new StringBuilder();
            while (characters[i] != delimiter) {
                lengthString.append(characters[i++]);
            }

            i++; // Skip delimiter.

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

// Time:
    // Encode: O(n + k). Must do a single pass of input array. k represents delimiter and word count length.
    // Decode: O(n) Single pass of character array 
// Space:
    // Encode: O(n). We build a String, which is a collection, from the input array.
    // Decode: O(n). We create a charArray: O(n) where n is number of characters in input.
        // We create two StringBuilders. Each is also a linear operation up to O(n).
        // We create a final result list that contains strings created from our input. 
        // All of these collections involve linear space so O(n). 
