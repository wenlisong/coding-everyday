import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 139. Word Break

// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
// determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note:
// The same word in the dictionary may be reused multiple times in the segmentation.
// You may assume the dictionary does not contain duplicate words.

// Example 1:
// Input: s = "leetcode", wordDict = ["leet", "code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// Example 2:
// Input: s = "applepenapple", wordDict = ["apple", "pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//              Note that you are allowed to reuse a dictionary word.

// Example 3:
// Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// Output: false
class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        final int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int l=1;l<=n;l++){
            for(int i=0;i<l;i++){
                if(dp[i]){
                    if(words.contains(s.substring(i, l))){
                        dp[l] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak solu = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean rst = solu.wordBreak(s, wordDict);
        System.out.println(rst);
    }
}