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
           int delimiterPosition = str.indexOf('#', i);

           int length = Integer.parseInt(str.substring(i, delimiterPosition));

           result.add(str.substring(delimiterPosition + 1, delimiterPosition + 1 + length));

           i = delimiterPosition + 1 + length;
        }

        return result;
    }
}
