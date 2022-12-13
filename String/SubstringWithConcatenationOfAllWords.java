import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 30. Substring with Concatenation of All Words
// You are given a string, s, and a list of words, words, that are all of the same length. 
// Find all starting indices of substring(s) in s that is a concatenation of each word in words 
// exactly once and without any intervening characters.

// Example 1:
// Input:
//   s = "barfoothefoobarman",
//   words = ["foo","bar"]
// Output: [0,9]
// Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
// The output order does not matter, returning [9,0] is fine too.

// Example 2:
// Input:
//   s = "wordgoodgoodgoodbestword",
//   words = ["word","good","best","word"]
// Output: []

class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || s.isEmpty() || words.length == 0) {
            return result;
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        int strLen = s.length(), numWords = words.length, wordLen = words[0].length();
        for (int i = 0; i < strLen - numWords * wordLen + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < numWords) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == numWords) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = { "foo", "bar" };
        SubstringWithConcatenationOfAllWords solution = new SubstringWithConcatenationOfAllWords();
        List<Integer> rst = solution.findSubstring(s, words);
        System.out.println(rst);
    }
}