class Solution {
    public boolean canSplit(int[] arr, int maxSum , int k){
        int noOfsubArr = 1;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(sum + arr[i] <= maxSum){
                sum += arr[i];
            }
            else{
                noOfsubArr++;
                sum = arr[i];
                if(noOfsubArr > k){
                    return false;
                }
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0 , high = 0;
        for(int i=0;i<nums.length;i++){
            low = Math.max(low , nums[i]);
            high += nums[i]; 
        }
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(canSplit(nums,mid,k)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}