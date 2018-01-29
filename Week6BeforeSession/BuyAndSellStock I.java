public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        
        if(A == null || A.size() == 0) {
            return 0;
        }
        
        int profit = 0;
        int minElement = Integer.MAX_VALUE;
        for(int i = 0; i < A.size(); i++){
            profit = Math.max(profit, A.get(i) - minElement);
            minElement = Math.min(minElement, A.get(i));        
        }
        return profit;
    }
}