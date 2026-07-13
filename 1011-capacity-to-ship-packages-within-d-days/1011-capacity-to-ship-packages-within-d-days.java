class Solution {
    static boolean isPossible(int[] arr,int days, int maxCap){
        int reqDays =  1;
        int currWeights = arr[0];
        for(int i=1;i<arr.length;i++){
            if(currWeights + arr[i] <= maxCap){
                currWeights += arr[i];
            } else {
                reqDays++;
                currWeights = arr[i];
                if(reqDays > days){
                    return false;
                }
            }
        }
        return true; 
    }
    public int shipWithinDays(int[] weights, int days) {
       int low = 0, high = 0;
       for(int i=0;i<weights.length;i++){
        low = Math.max(low,weights[i]);
        high += weights[i];
       } 
       int ans = 0;
       while(low <= high){
        int mid = (low + high)/2;
        if(isPossible(weights,days,mid)){
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }

       }
       return ans;
    }
}