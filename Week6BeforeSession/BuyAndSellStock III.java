public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if(A == null || A.size() == 0) {
            return 0;
        }
        
        int profit = 0;
        
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];
        
        left[0] = 0;
        int min = A.get(0);
        for(int i = 1; i < A.size(); i++) {
            min = Math.min(min, A.get(i));
            left[i] = Math.max(left[i-1], A.get(i) - min);
        }
        
        right[A.size()-1] = 0;
        int max = A.get(A.size()-1);
        for(int i = A.size() - 2; i >= 0; i--) {
            max = Math.max(max, A.get(i));
            right[i] = Math.max(right[i+1], max- A.get(i));
        }
        
        for(int i =0; i < A.size(); i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
}
