public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
         if(A == null || A.size() == 0) {
            return 0;
         }
         
        if(A.size() == 1) {
            return 1;
        }
        
        int[] list = new int[A.size()];
        int n = A.size();
        int max = Integer.MIN_VALUE;
        
        for(int i =0; i<n; i++) {
            list[i] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j =0; j < i; j++) {
                if(A.get(i) > A.get(j) && list[i] < list[j] + 1)
                    list[i] = list[j] + 1;
            }
        }
        
        for(int i =0; i < n; i++) {
            max = Math.max(max, list[i]);
        }
        
        return max;
    }
}
