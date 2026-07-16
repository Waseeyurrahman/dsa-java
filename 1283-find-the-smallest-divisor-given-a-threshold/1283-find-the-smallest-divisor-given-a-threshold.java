class Solution {
    public boolean isPossible(int[] arr, int divisor, int threshold){
        int sumOfDivisions = 0;
        for(int i=0;i<arr.length;i++){
            sumOfDivisions += ((arr[i] + divisor - 1) / divisor);
        }
        if(sumOfDivisions <= threshold){
            return true;
        } else {
            return false;
        }
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1 , high = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            high = Math.max(high , nums[i]);
        }
        int ans = 0;
        while(low <= high){
            int mid= (low + high)/2;
            if(isPossible(nums,mid,threshold)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}