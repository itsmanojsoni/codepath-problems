public class Solution {
    public int wordBreak(String A, ArrayList<String> B) {
        int[] t = new int[A.length() + 1];
        t[0] = 1;
        
        for(int i = 0; i < A.length(); i++) {
            if(t[i] == 0) {
                continue; 
            }
            
            for(String word : B) {
                int length = word.length();
                int end = i + length;
                if(end > A.length()) {
                    continue;
                }
                
                if(t[end] == 1) {
                    continue;
                }
                
                if(A.substring(i, end).equals(word)) {
                    t[end] = 1;
                }
            }
        }
        return t[A.length()];

    }
}