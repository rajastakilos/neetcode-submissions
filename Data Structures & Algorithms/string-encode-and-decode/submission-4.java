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
            while (characters[i] != delimiter) { // Stops at the delimiter. 
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
    // Encode: O(n + k)
        //   - We iterate over k strings
        //   - We append n total characters plus k length headers
        //   - Overall dominated by O(n)
        //
    // Decode: O(n)
        //   - Single left-to-right scan of the encoded string
        //   - Each character is processed exactly once 
// Space:
    // Encode: O(n)
        //   - Output string itself is O(n)
        //   - StringBuilder holds the output as it is constructed
    // Decode: O(n)
        //   - char[] copy of input string: O(n)
        //   - Output list stores decoded strings totaling O(n)
        //   - Length parsing uses O(log n) space (number of digits)
        //   - Temporary builders do not exceed the size of the current token
