import java.util.*;

// 140. Word Break II
// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
// add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

// Note:
// The same word in the dictionary may be reused multiple times in the segmentation.
// You may assume the dictionary does not contain duplicate words.

// Example 1:
// Input:
// s = "catsanddog"
// wordDict = ["cat", "cats", "and", "sand", "dog"]
// Output:
// [
//   "cats and dog",
//   "cat sand dog"
// ]

// Example 2:
// Input:
// s = "pineapplepenapple"
// wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
// Output:
// [
//   "pine apple pen apple",
//   "pineapple pen apple",
//   "pine applepen apple"
// ]
// Explanation: Note that you are allowed to reuse a dictionary word.

// Example 3:
// Input:
// s = "catsandog"
// wordDict = ["cats", "dog", "sand", "and", "cat"]
// Output:
// []

class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Map<String, List<String>> mem = new HashMap<>();
        return helper(s, words, mem);
    }

    private List<String> append(List<String> strList, String word) {
        List<String> rst = new ArrayList<>();
        for (String sentence : strList) {
            rst.add(sentence + " " + word);
        }
        return rst;
    }

    private List<String> helper(String s, Set<String> words, Map<String, List<String>> mem) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        List<String> ans = new ArrayList<>();
        if (words.contains(s)) {
            ans.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String right = s.substring(i);
            if (words.contains(right)) {
                String left = s.substring(0, i);
                List<String> left_ans = helper(left, words, mem);
                ans.addAll(append(left_ans, right));
            }
        }
        mem.put(s, ans);
        return mem.get(s);
    }

    public static void main(String[] args) {
        WordBreakII solu = new WordBreakII();
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" });
        List<String> rst = solu.wordBreak(s, wordDict);
        System.out.println(rst.toString());
    }
}