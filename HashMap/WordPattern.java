class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(ch)) {
                // same letter must map to same word
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            } else {
                // no two letters map to same word
                if (map.containsValue(word)) {
                    return false;
                }
                map.put(ch, word);
            }
        }
        return true;
    }
}
