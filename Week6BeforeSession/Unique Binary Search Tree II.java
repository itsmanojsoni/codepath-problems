public class Solution {
    public int numTrees(int A) {
        
        if(A < 0) {
            return 0;
         }
         
        int[] count = new int[A+1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i <= A; i++) {
            for(int j = 0; j <= i-1; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[A];
    }
}